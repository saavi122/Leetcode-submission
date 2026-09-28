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
    public int rob(TreeNode root) {
        List<Integer> res = dfs(root);
        return Math.max(res.get(0),res.get(1));
    }

    public List<Integer> dfs(TreeNode root){
        if(root == null) return Arrays.asList(0,0);

        List<Integer> left = dfs(root.left);
        List<Integer> right = dfs(root.right);

        int rob = root.val + left.get(0) + right.get(0);

        int notr = Math.max(left.get(0),left.get(1))+ Math.max(right.get(0),right.get(1));

        return Arrays.asList(notr,rob);
    }
}