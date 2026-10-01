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
    int ans;
    public int amountOfTime(TreeNode root, int start) {
        ans = 0;
        dfs(root,start);
        return ans;
    }
    public int dfs(TreeNode root, int start){
        if(root == null) return 0;
        int left = dfs(root.left,start);
        int right = dfs(root.right,start);
        if(root.val == start){
            ans = Math.max(left,right);
            return -1;
        }
        if(left >= 0 && right >= 0){
            return Math.max(left,right)+1;
        }else{
            int dist = Math.abs(left)+Math.abs(right);
            ans = Math.max(ans,dist);
        }
        return Math.min(left,right)-1;
    }
}