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
    List<TreeNode> res;
    boolean[] del;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        del = new boolean[1001];
        for(int n : to_delete){
            del[n] = true;
        }
        root = dfs(root);
        if(root != null) res.add(root);
        return res;
    }
    public TreeNode dfs(TreeNode root){
        if(root == null) return null;
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if(!del[root.val]) return root;
        if(root.left != null) res.add(root.left);
        if(root.right != null) res.add(root.right);

        return null;
    }
} 