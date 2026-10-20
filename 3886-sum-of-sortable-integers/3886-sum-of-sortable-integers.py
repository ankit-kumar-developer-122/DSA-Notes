class Solution:
    def sortableIntegers(self, nums: list[int]) -> int:
        n = len(nums)
        sorted_nums = sorted(nums)
        total_sum = 0
        
        for k in range(1, n + 1):
            if n % k != 0:
                continue
            
            possible = True
            for i in range(0, n, k):
                match = False
                block = nums[i:i + k]
                target = sorted_nums[i:i + k]
                
                # Check if sorted target block is a cyclic shift of the block
                target_str = "".join(chr(x) for x in target)
                block_str = "".join(chr(x) for x in block)
                
                if target_str in (block_str + block_str):
                    match = True
                
                if not match:
                    possible = False
                    break
            
            if possible:
                total_sum += k
                
        return total_sum