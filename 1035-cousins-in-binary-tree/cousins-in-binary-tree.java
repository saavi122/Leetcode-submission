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
    int l1 = 0, l2 = 0;
    TreeNode p1 = null, p2 = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,0,null,x,y);
        return p1 != p2 && l1 == l2;
    }
    public void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        if(root == null) return;

        if(root.val == x){
            l1 = level;
            p1 = parent;
        }
        if(root.val == y){
            l2 = level;
            p2 = parent;
        }
        dfs(root.left,level+1,root,x,y);
        dfs(root.right,level+1,root,x,y);
    }
}