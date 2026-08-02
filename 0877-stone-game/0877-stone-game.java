class Solution {
    private int  helper(int []piles, int [][]dp,  int l, int r){
        if(l > r){
            return 0;
        }
        if(l == r) return piles[l];
        
        if(dp[l][r] != -1) return dp[l][r];

        int tl = piles[l] - helper(piles, dp, l+1, r);
        int tr = piles[r] - helper(piles, dp, l, r-1);
        return dp[l][r] = Math.max(tl, tr);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int [][]dp = new int[n+1][n+1];
        for(int []a:dp){
            Arrays.fill(a, -1);
        }
        return helper(piles,dp , 0, n-1) > 0;
    }
}