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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        dfs(root, diameter);

        return diameter[0];
    }

    public int dfs(TreeNode root, int[] diameter){
        if(root == null)
            return 0;
        
        int l = dfs(root.left, diameter);
        int r = dfs(root.right, diameter);

        diameter[0] = Math.max(l + r, diameter[0]);

        return 1 + Math.max(l, r);        
    }

}
