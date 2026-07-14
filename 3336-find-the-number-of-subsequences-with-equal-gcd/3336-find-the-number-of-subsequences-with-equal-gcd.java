class Solution {
    private int[][][] dp;
    private final int MOD = 1000000007;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // dp[i][g1][g2] stores the number of pairs up to index i
        // with GCD of seq1 as g1 and GCD of seq2 as g2.
        dp = new int[n][maxVal + 1][maxVal + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxVal; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        // Total pairs with equal GCD minus 1 (to exclude both being empty, 
        // though our logic only returns valid pairs if both are non-empty).
        // We start from index 0, with initial GCDs as 0 (representing empty sets).
        return solve(0, 0, 0, nums, maxVal);
    }

    private int solve(int i, int g1, int g2, int[] nums, int maxVal) {
        // Base case: processed all elements
        if (i == nums.length) {
            // Both subsequences must be non-empty (g1 > 0, g2 > 0) and have equal GCD
            if (g1 > 0 && g1 == g2) {
                return 1;
            }
            return 0;
        }

        // Return memoized result if already calculated
        if (dp[i][g1][g2] != -1) {
            return dp[i][g1][g2];
        }

        // Choice 1: Skip the current element
        long ans = solve(i + 1, g1, g2, nums, maxVal);

        // Choice 2: Include in Subsequence 1
        int nextG1 = (g1 == 0) ? nums[i] : gcd(g1, nums[i]);
        ans = (ans + solve(i + 1, nextG1, g2, nums, maxVal)) % MOD;

        // Choice 3: Include in Subsequence 2
        int nextG2 = (g2 == 0) ? nums[i] : gcd(g2, nums[i]);
        ans = (ans + solve(i + 1, g1, nextG2, nums, maxVal)) % MOD;

        return dp[i][g1][g2] = (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}