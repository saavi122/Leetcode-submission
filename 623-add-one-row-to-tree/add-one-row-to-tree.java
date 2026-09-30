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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        return add(root,val,depth,1);
    }
    public TreeNode add(TreeNode root, int val, int depth, int cur){
        if(root == null) return null;
        if(cur == depth-1){
            TreeNode l = root.left;
            TreeNode r = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = l;
            root.right.right = r;
            return root;
        }
        root.left = add(root.left,val,depth,cur+1);
        root.right = add(root.right,val,depth,cur+1);
        return root;
    }
}