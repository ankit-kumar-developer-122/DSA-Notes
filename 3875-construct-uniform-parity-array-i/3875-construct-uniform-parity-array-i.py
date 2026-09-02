class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        n = len(nums1)
        
        def check(target_parity):
            for i in range(n):
                possible = False
                if nums1[i] % 2 == target_parity:
                    possible = True
                else:
                    for j in range(n):
                        if i != j and (nums1[i] - nums1[j]) % 2 == target_parity:
                            possible = True
                            break
                if not possible:
                    return False
            return True
            
        return check(0) or check(1)