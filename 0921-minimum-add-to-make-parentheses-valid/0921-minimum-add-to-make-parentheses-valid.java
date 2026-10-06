class Solution {
    public int minAddToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean found = true;

        while (found) {
            found = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == '(' && sb.charAt(i + 1) == ')') {
                    sb.delete(i, i + 2);
                    found = true;
                    break;
                }
            }
        }

        return sb.length();
    }
}