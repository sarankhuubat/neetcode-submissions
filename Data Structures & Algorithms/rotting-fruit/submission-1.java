class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                } else if(grid[r][c] == 1){
                    freshCount++;
                }
            }
        }

        while(freshCount > 0 && !q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                for(int[] dir : dirs){
                    int nr = r + dir[0], nc = c+ dir[1];
                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr,nc});
                        freshCount--;
                    }
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }
    
}
