class Solution {
    public int countPaths(int[][] grid) {
        return matrixDFS(grid, 0, 0, new int[grid.length][grid[0].length]);
    }

    private int matrixDFS(int[][] grid, int r, int c, int[][] visit){
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if(Math.min(r,c) < 0 || r == ROWS || c == COLS || visit[r][c] == 1 || grid[r][c] == 1)
            return 0;
        
        if(r == ROWS - 1 && c == COLS - 1)
            return 1;
        
        visit[r][c] = 1;

        int count = 0;
        count += matrixDFS(grid, r - 1, c, visit);
        count += matrixDFS(grid, r, c - 1, visit);
        count += matrixDFS(grid, r + 1, c, visit);
        count += matrixDFS(grid, r, c + 1, visit);

        visit[r][c] = 0;
        return count;
    }
}
