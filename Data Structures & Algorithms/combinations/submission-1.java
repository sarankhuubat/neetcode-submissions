class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, new ArrayList<>(), n, k);

        return res;
    }

    private void dfs(int i, List<Integer> curr, int n, int k){
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(i > n) return;

        for(int j = i; j < n + 1; j++){
            curr.add(j);
            dfs(j + 1, curr, n, k);
            curr.remove(curr.size() - 1);
        }
    }
}