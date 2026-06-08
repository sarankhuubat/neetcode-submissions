class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;
        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for(int[] d : dirs){
                int nr = r + d[0], nc = c + d[1];
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && image[nr][nc] == original){
                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}