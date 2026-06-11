class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        List<Integer> topoList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting  = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(!dfs(i, adj, visited, visiting, topoList)){
                return new ArrayList<>();
            }
        }

        Collections.reverse(topoList);
        return topoList;
    }

    private boolean dfs(int i, Map<Integer, List<Integer>> adj, Set<Integer> visited, Set<Integer> visiting, List<Integer> topoList){
        if(visited.contains(i)){
            return true;
        }

        if(visiting.contains(i)){
            return false;
        }

        visiting.add(i);
        for(int nei : adj.get(i)){
            if(!dfs(nei, adj, visited, visiting, topoList)){
                return false;
            }
        }

        visiting.remove(i);
        visited.add(i);
        topoList.add(i);

        return true;
    }
}
