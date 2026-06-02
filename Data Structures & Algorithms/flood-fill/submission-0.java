class Solution {
    private int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return dfs(image, sr, sc, color, image[sr][sc]);
    }

    private int[][] dfs(int[][] image, int r, int c, int color, int original){
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] == color)
            return image;

        if(image[r][c] == original){
            image[r][c] = color;
            for(int[] dir : dirs){
                dfs(image, r + dir[0], c + dir[1], color, original);
            }
        }

        return image;
    }
}
/*
[[1,1,1],
 [1,1,0],
 [1,0,1]]

[[1,1,1],
 [1,2,0],
 [1,0,1]]

[[1,2,1],
 [2,2,0],
 [1,0,1]]

[[2,2,2],
 [2,2,0],
 [2,0,1]]
*/