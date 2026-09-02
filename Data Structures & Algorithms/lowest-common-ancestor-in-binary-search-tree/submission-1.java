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
    TreeNode ans = null;
    boolean[] falseRes = new boolean[]{false, false};
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return ans;
    }
    boolean[] find(TreeNode n, TreeNode p, TreeNode q) {
        if (ans != null) return falseRes;
        if (n == null) return falseRes;
        boolean pf = false, qf = false;
        if (n == p) pf = true;
        if (n == q) qf = true;
        boolean[] findL = find(n.left, p, q), findR = find(n.right, p, q);
        pf = pf || findL[0] || findR[0];
        qf = qf || findL[1] || findR[1];
        if (pf && qf) {
            ans = n;
            return falseRes;
        }
        return new boolean[]{pf, qf};
    }
}
