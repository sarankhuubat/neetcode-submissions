class Solution {
    private int[][] dirs = new int[][]{{0,-1}, {1,0}, {-1,0}, {0,1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    isIsland(r, c, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void isIsland(int r, int c, char[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        if(r >= rows || c >= cols || r < 0 || c < 0 || grid[r][c] != '1'){
            return;
        }

        grid[r][c] = '0';
        for(int[] dir: dirs){
            isIsland(r + dir[0], c + dir[1], grid);
        }
    }
}
