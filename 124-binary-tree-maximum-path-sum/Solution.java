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
    int max;
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        int right = helper(root.right);
        int left = helper(root.left);
        if(left < 0) left = 0;
        if(right < 0) right = 0;
        // max = Math.max(root.val, max);
        max = Math.max(left + right + root.val, max);
        return Math.max(left, right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
}