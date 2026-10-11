class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalK = (long) k1 + k2;
        int maxDiff = 0;
        int[] diffCounts = new int[100001];
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            diffCounts[diff]++;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        
        for (int d = maxDiff; d > 0 && totalK > 0; d--) {
            if (diffCounts[d] > 0) {
                long take = Math.min((long) diffCounts[d], totalK);
                diffCounts[d] -= take;
                diffCounts[d - 1] += take;
                totalK -= take;
            }
        }
        
        long result = 0;
        for (int d = 0; d <= 100000; d++) {
            if (diffCounts[d] > 0) {
                result += (long) diffCounts[d] * d * d;
            }
        }
        
        return result;
    }
}