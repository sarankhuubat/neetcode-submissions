class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>());

        return res;
    }

    private void dfs(int n, int k, int i, List curr){
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(i > n)
            return;


        curr.add(i);
        dfs(n, k, i + 1, curr);
        curr.remove(curr.size() - 1);
        dfs(n, k, i + 1, curr);
    }
}