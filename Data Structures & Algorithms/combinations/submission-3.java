class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>());

        return res;
    }

    private void dfs(int i, int n, int k, List curr){
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i > n) return;

        curr.add(i);
        dfs(i + 1, n, k, curr);
        curr.remove(curr.size() - 1);
        dfs(i + 1, n, k, curr);
    }
}