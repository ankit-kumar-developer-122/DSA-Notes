class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        n = len(nums)
        def digit_sum(x):
            return sum(int(c) for c in str(x))
        
        indexed = [(digit_sum(nums[i]), nums[i], i) for i in range(n)]
        indexed.sort(key=lambda x: (x[0], x[1]))
        
        visited = [False] * n
        swaps = 0
        
        for i in range(n):
            if visited[i] or indexed[i][2] == i:
                continue
            
            cycle_size = 0
            curr = i
            while not visited[curr]:
                visited[curr] = True
                curr = indexed[curr][2]
                cycle_size += 1
            
            if cycle_size > 1:
                swaps += (cycle_size - 1)
                
        return swaps