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

    public boolean checkSubTree(TreeNode node, TreeNode root){
        if(node == null && root == null) return true;
        if((node == null && root != null) || (node != null && root == null)) return false;
        if(node.val != root.val) return false;
        return checkSubTree(node.left, root.left) && checkSubTree(node.right, root.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(subRoot == null) return true;
        if(checkSubTree(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
