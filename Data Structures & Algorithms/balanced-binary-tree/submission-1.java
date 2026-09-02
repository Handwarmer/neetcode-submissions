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
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }
    int dfs(TreeNode n) {
        if (n == null) return 0;
        if (!ans) return 0;
        int l = dfs(n.left), r = dfs(n.right);
        if (Math.abs(l - r) > 1) ans = false;
        return Math.max(l, r) + 1;
    }
}
