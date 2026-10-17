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

public class Codec {

    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = q.poll();
                if(node == null){
                    str.append("N ");
                } else {
                    str.append(node.val+" ");
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String s[] = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        for(int i = 1; i < s.length; i ++){
            TreeNode parent = q.poll();
            if(!s[i].equals("N")){
                TreeNode left = new TreeNode(Integer.parseInt(s[i]));
                parent.left = left;
                q.add(left);
            }
            if(!s[++i].equals("N")){
                TreeNode right = new TreeNode(Integer.parseInt(s[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
