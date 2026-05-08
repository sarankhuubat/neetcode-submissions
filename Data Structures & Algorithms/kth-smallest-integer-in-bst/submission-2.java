/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> tree = new ArrayList<>();

        dfs(root, tree);

        return tree.get(k-1);
    }

    private void dfs(TreeNode root, List tree){
        if(root == null)
            return;

        dfs(root.left, tree);
        tree.add(root.val);
        dfs(root.right, tree);
    }
}
