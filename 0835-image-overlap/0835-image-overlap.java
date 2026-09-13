class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        for (int rowShift = -n + 1; rowShift < n; rowShift++) {
            for (int colShift = -n + 1; colShift < n; colShift++) {
                maxOverlap = Math.max(maxOverlap, countOverlap(img1, img2, rowShift, colShift, n));
            }
        }

        return maxOverlap;
    }

    private int countOverlap(int[][] img1, int[][] img2, int rowShift, int colShift, int n) {
        int count = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int shiftedR = r + rowShift;
                int shiftedC = c + colShift;
                if (shiftedR >= 0 && shiftedR < n && shiftedC >= 0 && shiftedC < n) {
                    if (img1[r][c] == 1 && img2[shiftedR][shiftedC] == 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}