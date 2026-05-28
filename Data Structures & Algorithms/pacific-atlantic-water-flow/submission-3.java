class Solution {
    private int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] atl = new boolean[rows][cols];
        boolean[][] pac = new boolean[rows][cols];

        for(int c = 0; c < cols; c++){
            dfs(0, c, pac, heights, heights[0][c]);
            dfs(rows - 1, c, atl, heights, heights[rows - 1][c]);
        }

        for(int r = 0; r < rows; r++){
            dfs(r, 0, pac, heights, heights[r][0]);
            dfs(r, cols - 1, atl, heights, heights[r][cols-1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(atl[r][c] && pac[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visit, int[][] heights, int prev){
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || visit[r][c] || heights[r][c] < prev)
            return;
        
        visit[r][c] = true;
        for(int[] dir : dirs){
            dfs(r + dir[0], c + dir[1], visit, heights, heights[r][c]);
        }
    }
}