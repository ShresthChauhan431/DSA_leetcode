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
    int count = 0; 
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int countNode(TreeNode root){
        if(root == null){
            return 0; 
        }
        // if(map.containsKey(root)) return map.get(root);
        int ans = 1+countNode(root.left)+countNode(root.right);
        // map.put(root,ans);
        return ans;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = root.val+left+right;
        int node = countNode(root);
        if(sum/node == root.val){
            count++;
        }
        return sum;
    }
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }
}