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
    public int goodNodes(TreeNode root) {
        dfs(root, -101);
        return ans;
    }
    void dfs(TreeNode n, int max) {
        if (n == null) return;
        if (max <= n.val) ans ++;
        max = Math.max(max, n.val);
        dfs(n.left, max);
        dfs(n.right, max);
    }
}
