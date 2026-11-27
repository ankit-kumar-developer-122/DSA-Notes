class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        for (int[] item : items) {
            if (item[0] > maxFactor) {
                maxFactor = item[0];
            }
        }

        int[] freeByFactor = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            int count = 0;
            for (int[] item : items) {
                if (item[0] % f == 0) {
                    count++;
                }
            }
            freeByFactor[f] = count;
        }

        int[] freeGain = new int[n];
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int selfDivisible = (f % f == 0) ? 1 : 0;
            freeGain[i] = freeByFactor[f] - selfDivisible;
        }

        int[] dp = new int[budget + 1];
        Arrays.fill(dp, Integer.MIN_VALUE / 4);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int gainFirst = 1 + freeGain[i];
            int[] nextDp = Arrays.copyOf(dp, budget + 1);

            for (int b = 0; b <= budget; b++) {
                if (dp[b] < 0) {
                    continue;
                }
                if (b + price <= budget) {
                    nextDp[b + price] = Math.max(nextDp[b + price], dp[b] + gainFirst);
                }
                int cur = dp[b] + gainFirst;
                for (int cost = b + 2 * price; cost <= budget; cost += price) {
                    cur += 1;
                    nextDp[cost] = Math.max(nextDp[cost], cur);
                }
            }
            dp = nextDp;
        }

        int ans = 0;
        for (int val : dp) {
            if (val > ans) {
                ans = val;
            }
        }
        return ans;
    }
}