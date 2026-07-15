class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, adj, visiting)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int src, Map<Integer, List<Integer>> adj, Set<Integer> visiting){
        if(visiting.contains(src))
            return false;
        if(!adj.containsKey(src))
            return true;

        visiting.add(src);
        for(int pre : adj.get(src)){
            if(!dfs(pre, adj, visiting))
                return false;
        }

        visiting.remove(src);
        adj.remove(src);

        return true;
    } 
}
