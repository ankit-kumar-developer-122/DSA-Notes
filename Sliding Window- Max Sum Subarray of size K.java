/**
 * Problem: Max Sum Subarray of size K
 * Given an array of integers arr[] and a number k. Return the maximum sum of a subarray of size k.
 * * Example:
 * Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
 * Output: 39
 * Explanation: The subarray [4, 2, 10, 23] has the maximum sum = 39.
 */

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1; // Invalid case

        int i = 0;
        int j = 0;
        int sum = 0;
        int mx = Integer.MIN_VALUE;

        // 1. Calculate sum of the first window of size k
        while (j < k) {
            sum += arr[j++];
        }
        
        mx = Math.max(mx, sum);

        // 2. Slide the window: subtract element at i, add element at j
        while (j < n) {
            sum = (sum + arr[j]) - arr[i];
            mx = Math.max(mx, sum);
            i++;
            j++;
        }
        
        return mx;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Maximum Sum: " + sol.maxSubarraySum(arr, k));
    }
}
