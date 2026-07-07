/**
 * PROBLEM: Floor in a Sorted Array
 * Given a sorted array arr[] and an integer x, find the index (0-based) of the 
 * largest element in arr[] that is less than or equal to x.
 * * NOTE: In case of multiple occurrences of the floor of x, return the index 
 * of the last occurrence. If no such element exists, return -1.
 *
 * EXAMPLES:
 * 1. Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
 * Output: 1 (Value 2 is the largest <= 5)
 * 2. Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 11
 * Output: 4 (Value 10 is the largest <= 11; index 4 is the last occurrence)
 * 3. Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 0
 * Output: -1
 *
 * SOLUTION:
 */

class Solution {
    public int findFloor(int[] arr, int tar) {
        int low = 0;
        int high = arr.length - 1;
        int idx = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // If the element is equal to target, it's a potential floor.
            // We store it and keep looking right for a later occurrence.
            if (arr[mid] == tar) {
                idx = mid;
                low = mid + 1;
            } 
            // If the element is less than target, it's a potential floor.
            // We store it and keep looking right for a larger floor.
            else if (arr[mid] < tar) {
                idx = mid;
                low = mid + 1;
            } 
            // If the element is greater than target, look to the left.
            else {
                high = mid - 1;
            }
        }
        return idx;
    }
}
