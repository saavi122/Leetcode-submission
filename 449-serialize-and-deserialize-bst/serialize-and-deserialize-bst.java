/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        preorder(root,res);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] idx = {0};
        return build(arr, idx);
    }
    public void preorder(TreeNode root, StringBuffer res){
        if(root == null){
            res.append("#,");
            return;
        }
        res.append(root.val).append(",");
        preorder(root.left,res);
        preorder(root.right,res);
    }
    public TreeNode build(String[] arr, int[] idx){
        if(arr[idx[0]].equals("#")){
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx[0]]));
        idx[0]++;
        root.left = build(arr,idx);
        root.right = build(arr,idx);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;