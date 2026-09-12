class Solution {
    public long maxPairStrength(int[] nums) {
        long maxStrength = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long g = gcd(nums[i], nums[j]);
                long strength = ((long) nums[i] * nums[j]) / (g * g);
                if (strength > maxStrength) {
                    maxStrength = strength;
                }
            }
        }
        
        return maxStrength;
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