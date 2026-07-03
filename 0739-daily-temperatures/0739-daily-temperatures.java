class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stk = new Stack<>();
        int n = temp.length;
        int[] res = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements smaller than current temperature
            while (!stk.isEmpty() && temp[i] >= temp[stk.peek()]) {
                stk.pop();
            }
            
            // If stack is not empty, calculate the distance
            if (!stk.isEmpty()) {
                res[i] = stk.peek() - i;
            }
            
            // Push current index onto stack
            stk.push(i);
        }
        return res;
    }
}