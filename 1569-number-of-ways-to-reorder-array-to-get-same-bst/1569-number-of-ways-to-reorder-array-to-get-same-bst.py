class Solution:
    def numOfWays(self, nums: list[int]) -> int:
        mod = 10**9 + 7
        
        def count_ways(arr):
            if len(arr) <= 2:
                return 1
            
            root = arr[0]
            left_subtree = [x for x in arr if x < root]
            right_subtree = [x for x in arr if x > root]
            
            ways_left = count_ways(left_subtree)
            ways_right = count_ways(right_subtree)
            
            combinations = math.comb(len(left_subtree) + len(right_subtree), len(left_subtree))
            
            return (combinations * ways_left * ways_right) % mod
            
        return (count_ways(nums) - 1) % mod