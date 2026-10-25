class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int closedIslandsCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0 && !visited[r][c]) {
                    if (dfs(grid, visited, r, c, rows, cols)) {
                        closedIslandsCount++;
                    }
                }
            }
        }
        return closedIslandsCount;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }
        
        if (grid[r][c] == 1 || visited[r][c]) {
            return true;
        }

        visited[r][c] = true;

        boolean up = dfs(grid, visited, r - 1, c, rows, cols);
        boolean down = dfs(grid, visited, r + 1, c, rows, cols);
        boolean left = dfs(grid, visited, r, c - 1, rows, cols);
        boolean right = dfs(grid, visited, r, c + 1, rows, cols);

        return up && down && left && right;
    }
}