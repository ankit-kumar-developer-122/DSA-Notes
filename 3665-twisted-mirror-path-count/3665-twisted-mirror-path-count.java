class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1000000007;
        
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long left = 0;
        
        for (int i = 0; i < m; i++) {
            left = 0;
            for (int j = 0; j < n; j++) {
                long top = dp[j + 1];
                long right = 0;
                long down = 0;
                
                if (grid[i][j] == 0) {
                    right = (left + top) % MOD;
                    down = (left + top) % MOD;
                } else {
                    right = top;
                    down = left;
                }
                
                dp[j + 1] = down;
                left = right;
            }
        }
        
        return (int) left;
    }
}