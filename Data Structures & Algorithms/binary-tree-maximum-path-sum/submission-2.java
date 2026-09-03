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
        // n.val + l + r不能包含在res返回到父一级。因为那样父节点计算出来的path就会包含子节点的左和右，path上就会走子节点2次，就不满足path的定义了
        ans = Math.max(ans, n.val + l + r);
        return res;
    }
}
