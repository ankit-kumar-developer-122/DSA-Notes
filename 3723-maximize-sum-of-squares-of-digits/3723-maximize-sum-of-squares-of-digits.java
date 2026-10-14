class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 0 || sum > 9 * num) {
            return "";
        }
        
        int[] digits = new int[num];
        int remSum = sum;
        
        for (int i = 0; i < num; i++) {
            int take = Math.min(9, remSum);
            digits[i] = take;
            remSum -= take;
        }
        
        java.util.Arrays.sort(digits);
        
        StringBuilder sb = new StringBuilder();
        for (int i = num - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }
        
        return sb.toString();
    }
}