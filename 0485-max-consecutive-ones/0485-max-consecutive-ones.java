class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0 , n = nums.length , l = 0 , r = 0;

        for(int i = 0; i < n; ++i) {
            if(nums[i] == 0) {
                r++;
                l = r;
            } else {
                ans = Math.max(r - l + 1 , ans);
                r++;
            }
        }

        return ans;
    }
}