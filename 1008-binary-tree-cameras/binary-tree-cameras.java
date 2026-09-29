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
    int cnt;
    public int minCameraCover(TreeNode root) {
        cnt = 0;
        int x = dfs(root);
        return (x == -1) ? cnt+1 : cnt;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.min(left,right) == -1){
            cnt++;
            return 1;
        }
        if(Math.max(left,right) == 1){
            return 0;
        }
        return -1;
    }
}