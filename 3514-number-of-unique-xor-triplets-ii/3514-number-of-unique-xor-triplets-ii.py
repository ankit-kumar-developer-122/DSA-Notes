from typing import List

class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        unique_nums = list(set(nums))
        n = len(unique_nums)
        
        pairs_xor = set()
        for i in range(n):
            for j in range(i, n):
                pairs_xor.add(unique_nums[i] ^ unique_nums[j])

        triplets_xor = set()
        for pair in pairs_xor:
            for num in unique_nums:
                triplets_xor.add(pair ^ num)
                
        return len(triplets_xor)