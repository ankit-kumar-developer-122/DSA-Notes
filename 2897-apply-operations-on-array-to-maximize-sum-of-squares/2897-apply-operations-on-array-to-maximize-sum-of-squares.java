class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounts = new int[32];
        for (int num : nums) {
            for (int b = 0; b < 32; b++) {
                if ((num & (1 << b)) != 0) {
                    bitCounts[b]++;
                }
            }
        }
        
        long[] maxArray = new long[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            long currentVal = 0;
            for (int b = 0; b < 32; b++) {
                if (bitCounts[b] > 0) {
                    currentVal |= (1L << b);
                    bitCounts[b]--;
                }
            }
            maxArray[i] = currentVal;
        }
        
        for (int i = 0; i < maxArray.length; i++) {
            maxArray[i] = maxArray[i] * maxArray[i];
        }
        
        java.util.Arrays.sort(maxArray);
        
        long mod = 1000000007;
        long totalSum = 0;
        int n = maxArray.length;
        for (int i = 0; i < k; i++) {
            totalSum = (totalSum + maxArray[n - 1 - i]) % mod;
        }
        
        return (int) totalSum;
    }
}