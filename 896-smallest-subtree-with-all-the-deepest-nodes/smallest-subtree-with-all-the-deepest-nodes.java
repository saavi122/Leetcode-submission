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

    class Pair {
    int height;
    TreeNode node;

    Pair(int height, TreeNode node) {
        this.height = height;
        this.node = node;
    }
}
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return height(root).node;
    }

    public Pair height(TreeNode root) {
        if (root == null)
            return new Pair(-1, null);

        Pair left = height(root.left);
        Pair right = height(root.right);

        if (left.height > right.height)
            return new Pair(left.height + 1, left.node); 
        else if (right.height > left.height)
            return new Pair(right.height + 1, right.node); 
        else
            // both sides same depth → current root is answer
            return new Pair(left.height+1, root);
    }
}