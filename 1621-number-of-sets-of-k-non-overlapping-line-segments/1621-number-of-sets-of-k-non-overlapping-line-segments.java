class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int totalPoints = n + k - 1;
        int choose = 2 * k;
        
        return (int) nCr(totalPoints, choose);
    }

    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r;

        long num = 1, den = 1;
        for (int i = 1; i <= r; i++) {
            num = (num * (n - i + 1)) % MOD;
            den = (den * i) % MOD;
        }

        return (num * modInverse(den, MOD)) % MOD;
    }

    private long modInverse(long n, int m) {
        return power(n, m - 2, m);
    }

    private long power(long x, int y, int m) {
        long res = 1;
        x = x % m;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % m;
            y = y >> 1;
            x = (x * x) % m;
        }
        return res;
    }
}