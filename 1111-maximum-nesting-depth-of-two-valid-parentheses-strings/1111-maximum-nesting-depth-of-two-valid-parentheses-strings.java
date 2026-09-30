class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int maxDepth = 0;
        int currentDepth = 0;
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else {
                currentDepth--;
            }
        }

        int targetMax = (maxDepth + 1) / 2;
        int[] result = new int[n];
        
        solve(seq, 0, 0, 0, 0, 0, targetMax, new int[n], result);
        return result;
    }

    private boolean solve(String seq, int index, int depthA, int depthB, int maxA, int maxB, int targetMax, int[] current, int[] result) {
        if (index == seq.length()) {
            if (depthA == 0 && depthB == 0 && maxA <= targetMax && maxB <= targetMax) {
                System.arraycopy(current, 0, result, 0, seq.length());
                return true;
            }
            return false;
        }

        if (maxA > targetMax || maxB > targetMax) {
            return false;
        }

        char c = seq.charAt(index);

        current[index] = 0;
        int nextDepthA = depthA + (c == '(' ? 1 : -1);
        if (nextDepthA >= 0) {
            if (solve(seq, index + 1, nextDepthA, depthB, Math.max(maxA, nextDepthA), maxB, targetMax, current, result)) {
                return true;
            }
        }

        current[index] = 1;
        int nextDepthB = depthB + (c == '(' ? 1 : -1);
        if (nextDepthB >= 0) {
            if (solve(seq, index + 1, depthA, nextDepthB, maxA, Math.max(maxB, nextDepthB), targetMax, current, result)) {
                return true;
            }
        }

        return false;
    }
}