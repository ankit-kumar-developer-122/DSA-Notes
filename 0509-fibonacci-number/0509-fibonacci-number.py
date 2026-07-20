class Solution:
    def fib(self, n: int) -> int:
         return self.func(n)
        #return ans

    
    def func(self,num: int):
        if num == 0 or num == 1:
            return num
        return self.func(num - 1) + self.func(num-2)
        