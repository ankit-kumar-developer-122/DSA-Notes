class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        int[] last = new int[26];
        java.util.Arrays.fill(last, -1);
        
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            
            dp[i + 1] = (dp[i] * 2) % MOD;
            
            if (last[ch] != -1) {
                dp[i + 1] = (dp[i + 1] - dp[last[ch]] + MOD) % MOD;
            }
            
            last[ch] = i;
        }
        
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}