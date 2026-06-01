class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if(!dfs(0, -1, visit, list)){
            return false;
        }

        return visit.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj){
        if(visit.contains(node)){
            return false;
        }

        visit.add(node);
        for(int n : adj.get(node)){
            if(n == parent){
                continue;
            }

            if(!dfs(n, node, visit, adj)){
                return false;
            }
        }

        return true;
    }
}
