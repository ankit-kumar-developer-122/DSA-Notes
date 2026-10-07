class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    private void remove(String s, List<String> ans, int lastI, int lastJ, char[] par) {
        int count = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) count++;
            if (s.charAt(i) == par[1]) count--;
            if (count >= 0) continue;
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reversed);
        }
    }
}