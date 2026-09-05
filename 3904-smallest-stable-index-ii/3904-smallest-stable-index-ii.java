class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return -1;
        
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        
        int maxVal = nums[0];
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, nums[i]);
            if (maxVal - suffixMin[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}