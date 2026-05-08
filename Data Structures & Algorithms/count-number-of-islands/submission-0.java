class Solution {
    private static final int[][] directions = {
        {1,0},{-1,0},{0,1},{0,-1}
    };
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        int[][] visit = new int[rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        int rows = grid.length, cols = grid[0].length;

        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0')
            return;
        
        grid[r][c] = '0';
        for(int[] dir : directions){
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
