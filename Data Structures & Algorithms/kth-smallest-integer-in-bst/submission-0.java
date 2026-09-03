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
    int ans = 0, cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
    void dfs(TreeNode n, int k) {
        if (n == null || cnt >= k) return;
        dfs(n.left, k);
        if (++cnt == k) ans = n.val;
        dfs(n.right, k);
    }
}
