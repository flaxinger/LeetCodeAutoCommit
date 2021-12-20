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
    
    int sum;
    static final int MIN = -30000000;
    public int traverse(TreeNode node){
        
        int l_sum = MIN, r_sum = MIN;
        if(node.left!= null) 
            l_sum = node.val+(traverse(node.left));
        if(node.right!= null) 
            r_sum = node.val+(traverse(node.right));
        int result = Math.max(l_sum, Math.max(r_sum, Math.max(r_sum+l_sum-node.val, node.val)));
        sum = Math.max(sum, result);
        return Math.max(l_sum, Math.max(r_sum, node.val));
        
    }
    
    
    public int maxPathSum(TreeNode root) {
        sum = MIN;
        traverse(root);
        return sum;
    }
}