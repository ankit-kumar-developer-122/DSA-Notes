import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }

        Arrays.sort(nums);

        // 1. Modify the two smallest elements -> new range [nums[2], nums[n - 1]]
        int dropTwoSmallest = nums[n - 1] - nums[2];

        // 2. Modify the two largest elements -> new range [nums[0], nums[n - 3]]
        int dropTwoLargest = nums[n - 3] - nums[0];

        // 3. Modify one smallest and one largest -> new range [nums[1], nums[n - 2]]
        int dropOneEach = nums[n - 2] - nums[1];

        return Math.min(dropTwoSmallest, Math.min(dropTwoLargest, dropOneEach));
    }
}