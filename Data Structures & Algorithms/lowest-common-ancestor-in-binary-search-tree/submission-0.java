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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //return dfs(root, p , q);
        while (true) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;

        if(root.val > p.val && root.val > q.val){
            dfs(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val){
            dfs(root.right, p, q);
        }  
            
        return root;
        

    }
}
