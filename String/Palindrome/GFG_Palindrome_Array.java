/*Palindrome Array
Difficulty: BasicAccuracy: 43.54%Submissions: 84K+Points: 1
Given an array arr, the task is to find whether the arr is palindrome or not. If the arr is palindrome then return true else return false.

An array is said to be palindrome if its reverse array matches the original array. 

Examples:

Input: arr = [1, 2, 3, 2, 1]
Output: true
Explanation: Here we can see we have [1, 2, 3, 2, 1] if we reverse it we can find [1, 2, 3, 2, 1] which is the same as before. So, the answer is true.
Input: arr = [1, 2, 3, 4, 5]
Output: false
Explanation: Here we can see we have [1, 2, 3, 4, 5] if we reverse it we find [5, 4, 3, 2, 1] which is the not same as before. So, the answer false. */

class Solution {
    public static boolean isPerfect(int[] arr) {
        // code here
        int n = arr.length;
        
        for (int i = 0; i< n/2; i++){
            if (arr[i] != arr[n-i-1]){
                // Not a palindrome Array
                return false;
            }
        }
        return true;
    }
}
