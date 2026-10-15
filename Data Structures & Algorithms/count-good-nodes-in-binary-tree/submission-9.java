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
    public int max(TreeNode node, int max){
        if(node == null) return 0;
        int count = (node.val >= max)? 1:0;
        max = Math.max(max, node.val);
        count += max(node.left, max);
        count += max(node.right, max);
        return count;
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return max(root, root.val);
    }
}
