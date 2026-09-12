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
    private int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right  = helper(root.right);
        
        int leftp = 0, rightp = 0;

        if(root.left != null && root.left.val == root.val)
            leftp = 1 + left;

        if(root.right != null && root.right.val == root.val)
            rightp = 1 + right;
 
        max = Math.max(max, leftp + rightp);
        return Math.max(leftp, rightp);
    }

    public int longestUnivaluePath(TreeNode root) {
        max = 0; 
        helper(root);
        return max;
    }
}