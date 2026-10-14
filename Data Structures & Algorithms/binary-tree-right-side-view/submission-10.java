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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode rightSideNode = null;
            for(int i = 0; i < size; i ++){
                TreeNode node = q.poll();
                if(node != null){
                    rightSideNode = node;
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(rightSideNode != null){
                res.add(rightSideNode.val);
            }
        }
        return res;
    }
}
