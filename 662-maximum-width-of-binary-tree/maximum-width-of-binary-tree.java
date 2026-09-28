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
    class Node {
        TreeNode node;
        int idx;
        Node(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        q.add(new Node(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int left = 0, right = 0;
            for(int i = 0; i<size; i++){
                Node nd = q.remove();
                int idx = nd.idx;
                if(i==0) left = idx;
                if(i==size-1) right = idx;
                if(nd.node.left != null){
                    q.add(new Node(nd.node.left,2*nd.idx));
                }
                if(nd.node.right != null){
                    q.add(new Node(nd.node.right,2*nd.idx+1));
                }
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}