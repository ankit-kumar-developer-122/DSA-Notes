class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // '*' can be '(', ')', or empty
                minOpen--;
                maxOpen++;
            }

            if (maxOpen < 0) {
                return false; // More closing brackets than possible open brackets
            }

            if (minOpen < 0) {
                minOpen = 0; // minOpen cannot drop below 0
            }
        }

        return minOpen == 0;
    }
}