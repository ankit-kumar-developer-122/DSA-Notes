print("---Tail Recursion---")
count = 5
def tailrecursion():
    global count  # Tell Python to use the global 'count' variable
    if count == 0:
        return
    count -= 1
    tailrecursion()
    print("AKM",count)

tailrecursion()

print("---Head Recursion---")
count=0
def headrecursion():
    global count  # Tell Python to use the global 'count' variable
    if count == 5:
        return
    print("AKM",count)
    count += 1
    headrecursion()
    
headrecursion()



print("---Recursion with Parameter---")
def print_forward(count=0, limit=5):
    if count == limit:
        return
    print("AKM", count)           # Action before recursive call
    print_forward(count + 1, limit)

print("--- Forward Counting ---")
print_forward()


def print_reverse_unwind(count=0, limit=5):
    if count == limit:
        return
    print_reverse_unwind(count + 1, limit)  # Recurse down to base case
    print("AKM", count)                    # Action after recursive call

print("--- Reverse Counting (Unwinding) ---")
print_reverse_unwind()

#TC =o(N)

print("Q- print the 1st value 2nd Number of times")
def func(x,n):
    if n==0:
        return
    print(x)
    func(x,(n-1))

func(15,4)


print("Q- print 1 to N") # HEAD recursion
def func2(i=0,n=0):
    if i>n:
        return
    print(i,end=" ")
    func2(i+1,n)

func2(1,26)


print("\n")
print("Q- print N to 1") # Tail recursion
def func3(i,n):
    if i>n:
        return
    func2(i+1,n)
    print(i,end=" ")
    
func3(1,4)

print("\n-Parameterized---print Sum to N------")

def sums(summ,i,n):
    if i>n:
        print(summ)
        return
    sums(summ +i,i+1,n)

sums(0,1,10)

print("\n-Functional recursion---print Sum to N------")

def funcSum(n):
    if n==1:
        return 1
    return n + funcSum(n-1)
print("The sum is:",funcSum(10))


"""
===============================================================================
PROBLEM: Print 1 To N Without Loops
===============================================================================
Source: GeeksforGeeks
Difficulty: Basic

Description:
    Given a positive integer `n`, print numbers from 1 to `n` without using loops.
    Implement the function `printTillN(self, n)` to print the numbers as 
    space-separated integers.

Constraints:
    1 <= n <= 1000

Expected Time Complexity:  O(N)
Expected Auxiliary Space: O(N) (due to recursion call stack)
===============================================================================
"""


class Solution:
    def printTillN(self, n: int) -> None:
        """
        Prints numbers from 1 to n using Head Recursion (unwinding phase).
        
        Approach:
        1. Base Case: If n == 0, stop recursion and return.
        2. Recursive Step: Recursively call self.printTillN(n - 1) FIRST.
           This pushes calls (n, n-1, ..., 1) onto the call stack.
        3. Action (Print): Print `n` AFTER the recursive call returns.
           Because the stack unwinds from n=1 up to n, numbers are printed 
           in ascending order (1 2 3 ... n).
        """
        # Base case
        if n == 0:
            return

        # Recursive call (Head Recursion)
        self.printTillN(n - 1)

        # Print during the stack unwinding phase
        print(n, end=" ")


"""
===============================================================================
DRY RUN & RECURSION TREE
===============================================================================
Example Input: n = 4
Expected Output: 1 2 3 4

--- RECURSION TREE (CALL STACK BUILDING PHASE) ---
printTillN(4)
└── printTillN(3)
    └── printTillN(2)
        └── printTillN(1)
            └── printTillN(0)  --> Base Case Hit! (Returns immediately)

--- UNWINDING PHASE (ACTION & EXECUTION) ---
1. printTillN(0) finishes and returns to printTillN(1).
2. printTillN(1) resumes -> executes `print(1, end=" ")` -> Returns.
3. printTillN(2) resumes -> executes `print(2, end=" ")` -> Returns.
4. printTillN(3) resumes -> executes `print(3, end=" ")` -> Returns.
5. printTillN(4) resumes -> executes `print(4, end=" ")` -> Finished!

Final Output printed to console: 1 2 3 4 
===============================================================================
"""


# Driver code for testing locally
if __name__ == "__main__":
    sol = Solution()

    print("--- Test Case 1: n = 5 ---")
    sol.printTillN(5)
    print("\n")

    print("--- Test Case 2: n = 10 ---")
    sol.printTillN(10)
    print("\n")
