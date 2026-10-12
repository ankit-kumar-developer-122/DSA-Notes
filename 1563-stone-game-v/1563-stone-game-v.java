class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(memo[i], -1);
        }
        
        return dp(0, n - 1, stoneValue, prefixSum, memo);
    }
    
    private int dp(int l, int r, int[] stoneValue, int[] prefixSum, int[][] memo) {
        if (l == r) {
            return 0;
        }
        
        if (memo[l][r] != -1) {
            return memo[l][r];
        }
        
        int maxScore = 0;
        
        for (int i = l; i < r; i++) {
            int leftSum = prefixSum[i + 1] - prefixSum[l];
            int rightSum = prefixSum[r + 1] - prefixSum[i + 1];
            
            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + dp(l, i, stoneValue, prefixSum, memo));
            } else if (leftSum > rightSum) {
                maxScore = Math.max(maxScore, rightSum + dp(i + 1, r, stoneValue, prefixSum, memo));
            } else {
                int leftScore = leftSum + dp(l, i, stoneValue, prefixSum, memo);
                int rightScore = rightSum + dp(i + 1, r, stoneValue, prefixSum, memo);
                maxScore = Math.max(maxScore, Math.max(leftScore, rightScore));
            }
        }
        
        return memo[l][r] = maxScore;
    }
}