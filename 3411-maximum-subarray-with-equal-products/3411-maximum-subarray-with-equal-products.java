class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 2;
        long maxLcm = 2520;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long g = 0;
            long l = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                l = (l * nums[j]) / gcd(l, nums[j]);

                if (prod == l * g) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }

                if (prod > maxLcm * g) {
                    break;
                }
            }
        }

        return maxLen;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}