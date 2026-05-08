class Solution {
    int rows, cols;
    boolean pacific, atlantic;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        List<List<Integer>> result = new ArrayList();

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                pacific = false;
                atlantic = false;

                dfs(heights, r, c, Integer.MAX_VALUE);
                if(pacific && atlantic){
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, int prev){
        if(r < 0 || c < 0){
            pacific = true;
            return;
        }

        if(r >= rows || c >= cols){
            atlantic = true;
            return;
        }

        if(heights[r][c] > prev){
            return;
        }

        int tmp = heights[r][c];
        heights[r][c] = Integer.MAX_VALUE;
        for(int[] dir : dirs){
            dfs(heights, r + dir[0], c + dir[1], tmp);
            if(pacific && atlantic){
                break;
            }
        }

        heights[r][c] = tmp;
    }
}
