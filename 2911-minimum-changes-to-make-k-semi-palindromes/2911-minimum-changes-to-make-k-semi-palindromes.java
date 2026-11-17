class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                int minChanges = 1000000;
                
                for (int d = 1; d * d <= len; d++) {
                    if (len % d == 0) {
                        if (d < len) {
                            minChanges = Math.min(minChanges, getCost(s, i, j, d));
                        }
                        int d2 = len / d;
                        if (d2 < len) {
                            minChanges = Math.min(minChanges, getCost(s, i, j, d2));
                        }
                    }
                }
                cost[i][j] = minChanges;
            }
        }
        
        int[][] dp = new int[k + 1][n];
        for (int i = 0; i < n; i++) {
            dp[1][i] = cost[0][i];
        }
        
        for (int parts = 2; parts <= k; parts++) {
            for (int i = parts - 1; i < n; i++) {
                int minVal = 1000000;
                for (int p = parts - 2; p < i; p++) {
                    minVal = Math.min(minVal, dp[parts - 1][p] + cost[p + 1][i]);
                }
                dp[parts][i] = minVal;
            }
        }
        
        return dp[k][n - 1];
    }
    
    private int getCost(String s, int start, int end, int d) {
        int changes = 0;
        int len = end - start + 1;
        int groupLen = len / d;
        
        for (int g = 0; g < d; g++) {
            int left = 0, right = groupLen - 1;
            while (left < right) {
                if (s.charAt(start + g + left * d) != s.charAt(start + g + right * d)) {
                    changes++;
                }
                left++;
                right--;
            }
        }
        return changes;
    }
}