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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    int dfs(TreeNode n) {
        if (n == null) return 0;
        int l = dfs(n.left);
        int r = dfs(n.right);
        int res = Math.max(n.val, n.val + l);
        res = Math.max(res, n.val + r);
        ans = Math.max(ans, res);
        ans = Math.max(ans, n.val + l + r);
        return res;
    }
}
