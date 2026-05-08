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
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> lvl = new ArrayList<>();

            for(int i = q.size(); i > 0; i--){
                TreeNode tmp = q.poll();
                if(tmp != null){
                    lvl.add(tmp.val);
                    q.add(tmp.left);
                    q.add(tmp.right);
                }
            }

            if(lvl.size() > 0){
                list.add(lvl);
            }
        }
    
        return list;

    }
}
