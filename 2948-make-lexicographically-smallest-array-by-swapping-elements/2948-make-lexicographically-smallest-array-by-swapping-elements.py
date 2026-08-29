class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        n = len(nums)
        sorted_pairs = sorted([(nums[i], i) for i in range(n)])
        
        res = [0] * n
        i = 0
        while i < n:
            j = i + 1
            while j < n and sorted_pairs[j][0] - sorted_pairs[j - 1][0] <= limit:
                j += 1
            
            group_indices = sorted([sorted_pairs[k][1] for k in range(i, j)])
            
            for k, idx in enumerate(group_indices):
                res[idx] = sorted_pairs[i + k][0]
                
            i = j
            
        return res