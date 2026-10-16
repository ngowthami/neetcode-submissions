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
    public int maxSum(TreeNode node, int res[]){
        if(node == null) return 0;
        int left = Math.max(0, maxSum(node.left, res));
        int right = Math.max(0, maxSum(node.right, res));
        res[0] = Math.max(res[0], left+right+node.val);
        int max = Math.max(left,right)+node.val;
        return Math.max(0, max);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int res[] = new int[1];
        res[0] = root.val;
        maxSum(root, res);
        return res[0];
    }
}
