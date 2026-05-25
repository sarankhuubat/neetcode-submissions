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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curr = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode tmp = q.poll();
                //if(tmp != null){
                    curr.add(tmp.val);

                    if(tmp.left != null)
                        q.add(tmp.left);
                    
                    if(tmp.right != null)
                        q.add(tmp.right);
                //}
            }

            if(curr.size() > 0)
                res.add(curr);
        }

        return res;
    }
}
