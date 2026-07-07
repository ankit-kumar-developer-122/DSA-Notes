class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;      // concatenated non-zero digits
        long sum = 0;    // sum of digits in x
        String s = String.valueOf(n);
        for (char c : s.toCharArray()) {
            if (c != '0') {
                int digit = c - '0';
                x = x * 10 + digit; // build x
                sum += digit;       // accumulate sum
            }
        }

        // If no non-zero digits, x = 0, sum = 0
        return x * sum;
    }
}
