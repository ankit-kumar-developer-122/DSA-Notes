// Method 1
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low =1; int high = arr.length -2;
        while(low <= high){
            int mid= (low + high)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1] && mid>0 && mid<arr.length-1) return mid;
            else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1] && mid>0 && mid<arr.length-1) low= mid+1;
            else high = mid-1;
        }
        return -1;
    }
}

// Method 2:
/**
 * PROBLEM: 852. Peak Index in a Mountain Array
 * * DESCRIPTION:
 * You are given an integer mountain array 'arr' of length n where the values 
 * increase to a peak element and then decrease. Return the index of the 
 * peak element. You must solve it in O(log(n)) time complexity.
 * * EXAMPLE:
 * Input: arr = [0, 10, 5, 2]
 * Output: 1 (The peak element is 10 at index 1)
 * * EXPLANATION:
 * To achieve O(log(n)) complexity, we use Binary Search.
 * 1. Define search space: low = 0, high = arr.length - 1.
 * 2. Calculate mid = low + (high - low) / 2.
 * 3. Compare arr[mid] with its neighbor arr[mid + 1]:
 * - If arr[mid] < arr[mid + 1], we are in the increasing part, 
 * so the peak must be to the right (low = mid + 1).
 * - If arr[mid] > arr[mid + 1], we are either at the peak or in 
 * the decreasing part, so the peak is at mid or to the left (high = mid).
 * 4. When low == high, we have found the peak.
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // Perform Binary Search
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if we are in the increasing part
            if (arr[mid] < arr[mid + 1]) {
                // Peak must be to the right, excluding mid
                low = mid + 1;
            } else {
                // Peak is at mid or to the left, including mid
                high = mid;
            }
        }
        
        // When low == high, we have found the peak index
        return low;
    }
}
