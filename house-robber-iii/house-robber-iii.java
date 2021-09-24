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
    
    private int[] trav(TreeNode node){
        
        // {child best, child next best}
        int[] larr = {0, 0};
        int[] rarr = {0, 0};
        int[] result = {0, 0};
        
        if(node.left!= null) larr = trav(node.left);
        if(node.right!= null) rarr = trav(node.right);
        result[1] = larr[0]+rarr[0];
        result[0] = Math.max(larr[1]+rarr[1]+node.val, result[1]);
        return result;
        
    }
    public int rob(TreeNode root) {
        
        return trav(root)[0];
    }
}