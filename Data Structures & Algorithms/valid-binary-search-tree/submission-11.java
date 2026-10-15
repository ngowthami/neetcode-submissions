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
    public boolean isValidTree(TreeNode node, int min, int max){
        if(node == null) return true;
        if(node.val >= max || node.val <= min){
            return false;
        }
        return isValidTree(node.left, min, node.val) && isValidTree(node.right,node.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
