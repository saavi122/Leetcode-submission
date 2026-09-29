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
    public int distributeCoins(TreeNode root) {
        TreeNode par = new TreeNode();
        return dfs(root,par);
    }
    public int dfs(TreeNode root, TreeNode par){
        if(root == null) return 0;
        int moves = dfs(root.left,root) + dfs(root.right,root);
        int nd = root.val - 1;
        par.val += nd;
        moves += Math.abs(nd);
        return moves;
    }
}