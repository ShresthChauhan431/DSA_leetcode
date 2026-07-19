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
    public int dfs(TreeNode root){
        if(root == null) return -1;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        int max = Math.max(root.val, Math.max(left, right));
        if(max == root.val){
            ans++;
        }
        return max;
    }
    public int countDominantNodes(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return ans;
    }
}