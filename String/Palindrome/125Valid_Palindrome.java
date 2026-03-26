/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome. */

class Solution {
    boolean isPalindrome(String s) {
        // code here
        s = s.toLowerCase(); // convert to Lowercase
        s = s.replaceAll("[^a-z0-9]",""); // remove non- alphanumeric 
       
        int n = s.length();
        for(int i=0 ; i < n/2; i++){
            if (s.charAt(i) != s.charAt(n-i-1)){
                // not a palindrome
                return false;
            }
        }
        return true;
    }
}