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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode t = q.pop();
            if (t == null) {
                sb.append("null,");
                continue;
            } 
            sb.append(t.val).append(",");
            q.add(t.left);
            q.add(t.right);
        }
        return sb.toString();
    }

    String[] sl;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] sl = data.split(",");
        Deque<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(sl[0]));
        q.add(root);
        for (int i = 1; i < sl.length;) {
            TreeNode cur = q.pop();
            if (!sl[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(sl[i]));
                cur.left = left;
                q.add(left);
            }
            i ++;
            if (!sl[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(sl[i]));
                cur.right = right;
                q.add(right);
            }
            i ++;
        }
        return root;
    }
}
