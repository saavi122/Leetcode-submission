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
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return null;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return build(list,0,list.size()-1);
    }
    public TreeNode build(List<Integer> val, int l, int r) {
        if (l > r) return null;
        int mid = (l+r)/2;
        TreeNode node = new TreeNode(val.get(mid));
        node.left = build(val,l,mid-1);
        node.right = build(val,mid+1,r);
        return node;
    }
    public void inorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}