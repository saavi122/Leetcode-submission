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
    int maxlen = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root,0,0);
        dfs(root,1,0);
        return maxlen;
    }
    public void dfs(TreeNode root, int dir, int curmax){
        if(root == null) return;
        maxlen = Math.max(curmax,maxlen);
        if(dir == 1){
            dfs(root.left,0,curmax+1);
            dfs(root.right,1,1);
        }else{
            dfs(root.right,1,curmax+1);
            dfs(root.left,0,1);
        }
    }
}