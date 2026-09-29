class Solution {
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if ((m + n - 1) % 2 != 0) return false;
        
        int maxBalance = (m + n) / 2;
        memo = new Boolean[m][n][maxBalance + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance) {
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0 || balance > (grid.length + grid[0].length) / 2) {
            return false;
        }

        int m = grid.length;
        int n = grid[0].length;

        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean result = false;
        if (r + 1 < m) {
            result = result || dfs(grid, r + 1, c, balance);
        }
        if (c + 1 < n) {
            result = result || dfs(grid, r, c + 1, balance);
        }

        return memo[r][c][balance] = result;
    }
}