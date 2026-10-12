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
    public int diameter(TreeNode node, int res[]){
        if(node == null) return 0;
        int left = diameter(node.left, res);
        int right = diameter(node.right, res);
        res[0] = Math.max(left+right, res[0]);
        return Math.max(left, right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int res[] = new int[1];
        diameter(root, res);
        return res[0];
    }
}
