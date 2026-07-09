/**
 * Problem: Search in a Rotated Sorted Array
 * * Given an array 'arr' of distinct elements that was originally sorted in 
 * ascending order but has been rotated at some unknown pivot, find the 
 * index of a target 'key'. If not found, return -1.
 * * Approach: Modified Binary Search
 * Since the array is partially sorted, in any given subarray [low...high], 
 * at least one half (either left or right of mid) must be sorted. We use 
 * this property to narrow down the search space in O(log n) time.
 */

public class RotatedArraySearch {

    /**
     * Searches for a target in a rotated sorted array.
     * @param arr The rotated sorted array
     * @param target The value to find
     * @return Index of the target, or -1 if not found
     */
    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Identify which half is sorted
            if (arr[low] <= arr[mid]) {
                // Left half [low...mid] is sorted
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1; // Target is in the left sorted portion
                } else {
                    low = mid + 1;  // Target must be in the right portion
                }
            } else {
                // Right half [mid...high] is sorted
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;  // Target is in the right sorted portion
                } else {
                    high = mid - 1; // Target must be in the left portion
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Example 1: Target exists
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target1 = 3;
        System.out.println("Example 1 Index: " + search(arr1, target1)); // Output: 8

        // Example 2: Target does not exist
        int[] arr2 = {3, 5, 1, 2};
        int target2 = 6;
        System.out.println("Example 2 Index: " + search(arr2, target2)); // Output: -1

        // Example 3: Simple sorted array (no rotation)
        int[] arr3 = {10, 20, 30, 40};
        int target3 = 20;
        System.out.println("Example 3 Index: " + search(arr3, target3)); // Output: 1
    }
}
