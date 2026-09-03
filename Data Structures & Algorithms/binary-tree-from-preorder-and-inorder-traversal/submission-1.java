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
    int[] preorder, inorder;
    Map<Integer, Integer> m = new HashMap<>();
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i ++) {
            m.put(inorder[i], i);
        }
        return dfs(0, inorder.length-1);
    }
    TreeNode dfs(int l, int r) {
        if (l > r) return null;
        TreeNode n = new TreeNode(preorder[preIdx++]);
        int mid = m.get(n.val);
        n.left = dfs(l, mid - 1);
        n.right = dfs(mid+1, r);
        return n;
    }
}
