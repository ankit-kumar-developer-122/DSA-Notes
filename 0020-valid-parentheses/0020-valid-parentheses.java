import java.util.*;

class Solution {
    public boolean isValid(String s) {
        // Keep removing valid pairs until no more can be removed
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        // If string is empty → all brackets matched
        return s.isEmpty();
    }
}
