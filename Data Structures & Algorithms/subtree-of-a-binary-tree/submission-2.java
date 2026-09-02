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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return serialize(root).contains(serialize(subRoot));
    }

    private String serialize(TreeNode n) {
        StringBuilder sb = new StringBuilder();
        if (n == null) sb.append("^");
        else sb.append("#" + n.val + serialize(n.left) + serialize(n.right));
        return sb.toString();
    }
}
