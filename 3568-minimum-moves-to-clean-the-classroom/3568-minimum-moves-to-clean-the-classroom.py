from collections import deque
from typing import List

class Solution:
    def minMoves(self, classroom: List[str], energy: int) -> int:
        m, n = len(classroom), len(classroom[0])
        litter = []
        
        for i in range(m):
            for j in range(n):
                if classroom[i][j] == 'S':
                    sx, sy = i, j
                elif classroom[i][j] == 'L':
                    litter.append((i, j))
        
        litter_idx = {pos: i for i, pos in enumerate(litter)}
        target_mask = (1 << len(litter)) - 1
        
        best_energy = [[[-1] * (target_mask + 1) for _ in range(n)] for _ in range(m)]
        best_energy[sx][sy][0] = energy
        
        queue = deque([(sx, sy, 0, energy, 0)])
        
        while queue:
            r, c, mask, e, steps = queue.popleft()
            
            if mask == target_mask:
                return steps
                
            if e == 0:
                continue
                
            for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nr, nc = r + dr, c + dc
                
                if 0 <= nr < m and 0 <= nc < n and classroom[nr][nc] != 'X':
                    ne = energy if classroom[nr][nc] == 'R' else e - 1
                    nmask = mask
                    
                    if classroom[nr][nc] == 'L':
                        nmask |= (1 << litter_idx[(nr, nc)])
                        
                    if ne > best_energy[nr][nc][nmask]:
                        best_energy[nr][nc][nmask] = ne
                        queue.append((nr, nc, nmask, ne, steps + 1))
                        
        return -1