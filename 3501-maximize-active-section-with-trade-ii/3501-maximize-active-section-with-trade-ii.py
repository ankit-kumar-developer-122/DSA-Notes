from typing import List
import math

class Solution:
    def maxActiveSectionsAfterTrade(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        
        # 1. Zero groups aur character index mapping setup
        zero_groups = []  # [{start, length}]
        zero_group_idx = [-1] * n
        
        for i in range(n):
            if s[i] == '0':
                if i > 0 and s[i - 1] == '0':
                    zero_groups[-1]['length'] += 1
                else:
                    zero_groups.append({'start': i, 'length': 1})
            zero_group_idx[i] = len(zero_groups) - 1

        total_ones = s.count('1')
        if not zero_groups:
            return [total_ones] * len(queries)

        # 2. Pre-calculate merge lengths of adjacent 0-groups
        num_groups = len(zero_groups)
        merge_lengths = []
        for i in range(num_groups - 1):
            merge_lengths.append(zero_groups[i]['length'] + zero_groups[i + 1]['length'])
            
        # 3. Sparse Table implementation for O(1) range max query
        m = len(merge_lengths)
        if m > 0:
            max_log = m.bit_length()
            st = [[0] * m for _ in range(max_log)]
            st[0] = list(merge_lengths)
            for i in range(1, max_log):
                for j in range(m - (1 << i) + 1):
                    st[i][j] = max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))])
                    
            def query_st(l: int, r: int) -> int:
                if l > r or l < 0 or r >= m:
                    return 0
                k = (r - l + 1).bit_length() - 1
                return max(st[k][l], st[k][r - (1 << k) + 1])
        else:
            def query_st(l: int, r: int) -> int:
                return 0

        res = []
        
        # 4. Process queries
        for l, r in queries:
            g_l = zero_group_idx[l]
            g_r = zero_group_idx[r]
            
            # Substring ke edges par kitne '0's range me include hue hain
            left_part = 0 if g_l == -1 else zero_groups[g_l]['length'] - (l - zero_groups[g_l]['start'])
            right_part = 0 if g_r == -1 else (r - zero_groups[g_r]['start'] + 1)
            
            ans = total_ones
            
            # Boundary range calculation for inner complete 0-groups
            start_adj = g_l + 1
            end_adj = (g_r if s[r] == '1' else g_r - 1) - 1
            
            if s[l] == '0' and s[r] == '0' and g_l + 1 == g_r:
                ans = max(ans, total_ones + left_part + right_part)
            elif start_adj <= end_adj:
                ans = max(ans, total_ones + query_st(start_adj, end_adj))
                
            if s[l] == '0' and g_l + 1 <= (g_r if s[r] == '1' else g_r - 1):
                ans = max(ans, total_ones + left_part + zero_groups[g_l + 1]['length'])
                
            if s[r] == '0' and g_l < g_r - 1:
                ans = max(ans, total_ones + right_part + zero_groups[g_r - 1]['length'])
                
            res.append(ans)
            
        return res