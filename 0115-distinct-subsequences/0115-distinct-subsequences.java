class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[i][j] = number of distinct subsequences of s[0..i-1] that form t[0..j-1]
        long[][] dp = new long[m + 1][n + 1];

        // Base case: empty t can always be formed (1 way)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Either use this character or skip it
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Skip current character of s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return (int) dp[m][n];
    }
}
