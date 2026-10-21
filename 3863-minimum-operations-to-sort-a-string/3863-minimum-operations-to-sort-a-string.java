class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                isSorted = false;
                break;
            }
        }
        
        if (isSorted) {
            return 0;
        }
        
        if (n == 2) {
            return -1;
        }
        
        char minChar = s.charAt(1);
        char maxChar = s.charAt(1);
        
        for (int i = 1; i < n - 1; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }
        
        char first = s.charAt(0);
        char last = s.charAt(n - 1);
        
        if (first <= Math.min(minChar, last) || Math.max(first, maxChar) <= last) {
            return 1;
        }
        
        if (last < minChar && minChar <= maxChar && maxChar < first) {
            return 3;
        }
        
        return 2;
    }
}