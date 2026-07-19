"""
================================================================================
PROBLEM DESCRIPTION
================================================================================
Problem: Armstrong Numbers (3-digit)
Difficulty: Easy
Source: GeeksforGeeks

You are given a 3-digit number n. Find whether it is an Armstrong number or not.
An Armstrong number of three digits is a number such that the sum of the cubes 
of its digits is equal to the number itself.

Constraints:
100 <= n < 1000

================================================================================
EXAMPLES
================================================================================
Example 1:
Input : n = 153
Output: True
Explanation: 153 is an Armstrong number since 1^3 + 5^3 + 3^3 = 153.

Example 2:
Input : n = 372
Output: False
Explanation: 372 is not an Armstrong number since 3^3 + 7^3 + 2^3 = 378 != 372.

================================================================================
DRY RUN BREAKDOWN (Example: n = 153)
================================================================================
Initialization:
  - num = 153
  - total = 0
  - nod = len(str(153)) -> 3

Loop Iterations (while num > 0):

  Iteration 1:
    - ld = 153 % 10 -> 3
    - total = 0 + (3 ** 3) -> 0 + 27 -> 27
    - num = 153 // 10 -> 15

  Iteration 2:
    - ld = 15 % 10 -> 5
    - total = 27 + (5 ** 3) -> 27 + 125 -> 152
    - num = 15 // 10 -> 1

  Iteration 3:
    - ld = 1 % 10 -> 1
    - total = 152 + (1 ** 3) -> 152 + 1 -> 153
    - num = 1 // 10 -> 0

End of Loop:
  - Condition (num > 0) becomes False (0 > 0 is False).
  - return total == n -> 153 == 153 -> Returns True.
================================================================================
"""

#  SOLUTION HERE

class Solution:
    def armstrongNumber(self, n: int) -> bool:
        # code here
        num = n
        total = 0
        nod = len(str(n))
        
        while num > 0:
            ld = num % 10
            total = total + (ld ** nod)
            num = num // 10
            
        return total == n


# ================================================================================
# DRIVER CODE & TEST CASES
# ================================================================================
if __name__ == "__main__":
    sol = Solution()
    
    # Test cases to validate the solution
    test_cases = [153, 371, 372, 100]
    
    print("Running Test Cases:")
    print("-" * 30)
    for n in test_cases:
        result = sol.armstrongNumber(n)
        print(f"Input: n = {n} -> Output: {result}")
