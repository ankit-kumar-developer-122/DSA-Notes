/**
 * PROBLEM: 2529. Maximum Count of Positive Integer and Negative Integer
 * * DESCRIPTION:
 * Given a sorted array, return the maximum of the count of positive integers
 * and the count of negative integers.
 * * EXAMPLE:
 * Input: nums = [-3, -2, -1, 0, 0, 1, 2]
 * Output: 3
 * * EXPLANATION:
 * - Negative numbers are everything before the first index where value >= 0.
 * - Positive numbers are everything after the last index where value <= 0.
 * - We use Binary Search to find these boundaries in O(log n) time.
 */

class Solution {
    public int maximumCount(int[] nums) {
        // Find the index of the first element >= 0 (start of non-negatives)
        int negCount = findFirstIndex(nums, 0);
        
        // Find the index of the first element > 0 (start of positives)
        int firstPosIndex = findFirstIndex(nums, 1);
        int posCount = nums.length - firstPosIndex;
        
        return Math.max(negCount, posCount);
    }

    // Binary search helper to find the first index where element >= target
    private int findFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}