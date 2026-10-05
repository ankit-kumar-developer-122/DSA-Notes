class Solution {
    public int scoreOfParentheses(String s) {
        if (s.equals("()")) {
            return 1;
        }
        int balance = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(') balance++;
            else balance--;
            if (balance == 0) {
                return scoreOfParentheses(s.substring(0, i + 1)) 
                     + scoreOfParentheses(s.substring(i + 1));
            }
        }
        return 2 * scoreOfParentheses(s.substring(1, s.length() - 1));
    }
}