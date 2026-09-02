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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode n) {
        if (n == null) return 0;
        int l = dfs(n.left), r = dfs(n.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }
}
