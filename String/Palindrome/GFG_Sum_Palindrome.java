/*Sum Palindrome
Difficulty: BasicAccuracy: 19.13%Submissions: 48K+Points: 1Average Time: 5m
Given a number, reverse it and add it to itself unless it becomes a palindrome or return -1 if the number of iterations becomes more than 5. Return that palindrome number if it becomes a palindrome else, it returns -1.

Examples:

Input: n = 23
Output: 55 
Explanation: reverse(23) = 32, then 32+23 = 55 which is a palindrome. 
Input: n = 73
Output: 121
Explanation: reverse(73) = 37, then 37+73 = 110 which is not a palindrome, again reverse(110)= 011, then 110+11 = 121 which is a palindrome. */

class Solution {
    // Palindrome check
    private boolean isPalindrome(long n) {
        String s = Long.toString(n);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
    // reverse
    private long reverse(long n) {
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);// n%10 == last digit
            n /= 10;
        }
        return rev;
    }

    public long isSumPalindrome(long n) {
        for (int i = 0; i < 5; i++) {
            if (isPalindrome(n)) {
                return n;
            }
            n = n + reverse(n);
        }
        return isPalindrome(n) ? n : -1;
    }
}
