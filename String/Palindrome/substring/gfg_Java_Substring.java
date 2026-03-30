/*https://www.geeksforgeeks.org/problems/java-substring5058/1

Given a string S and two integers L and R. Print the characters in the range L to R of the string.
NOTE: Assume zero based indexing.

Example 1:

Input: 
S = "cdbkdub"
L = 0 , R = 5
Output: "cdbkdu" 
Explanation: Starting from index 0 ('c')
to index 5 ('u').
Example 2:

Input: 
S = "sdiblcsdbud"
L = 3 , R = 7
Output: "blcsd"
Explanation: Starting from index 3 ('b')
to index 7 ('d').

Your Task:  
You dont need to read input or print anything. Complete the function javaSub() which takes S, L, R as
input parameter and returns the sting from the range L to R.*/

// User function template for Java
class Solution {
    static String javaSub(String S, int L, int R) {
        // code here
        return S.substring(L, R+1);
    }
}