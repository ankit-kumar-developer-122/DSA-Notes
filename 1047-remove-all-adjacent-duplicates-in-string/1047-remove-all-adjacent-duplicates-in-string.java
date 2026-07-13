class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == currentChar) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }
}