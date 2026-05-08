class Solution {
    private int[][] dirs = new int[][] {
        {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    helper(r, c, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void helper(int r, int c, char[][] grid){
        int rows = grid.length, cols = grid[0].length;

        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1'){
            return;
        }

        grid[r][c] = '0';
        for(int[] dir : dirs){
            helper(r + dir[0], c + dir[1], grid);
        }
    }
}
