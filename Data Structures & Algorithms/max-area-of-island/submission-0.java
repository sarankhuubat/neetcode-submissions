class Solution {
    private static int[][] dirs = {
        {1, 0},{-1, 0},{0, 1},{0, -1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxCount = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    int curr = dfs(grid, r, c);
                    maxCount = Math.max(maxCount, curr);
                }
            }
        }
        return maxCount;
    }

    private int dfs(int[][] grid, int r, int c){
        int rows = grid.length, cols = grid[0].length;

        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0)
            return 0;

        grid[r][c] = 0;
        int count = 1;
        for(int[] dir : dirs){
            count += dfs(grid, r + dir[0], c + dir[1]);
        }

        return count;
    }
}
