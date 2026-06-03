class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(i, visit, list);
                components += 1;
            }
        }

        return components;
    }

    private void dfs(int node, boolean[] visit, List<List<Integer>> list){
        visit[node] = true;

        for(int n : list.get(node)){
            if(!visit[n]){
                dfs(n, visit, list);
            }
        }
    }
}
