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
    
    
    static final double INF = Double.MAX_VALUE;
    public boolean func(TreeNode node, double max, double min){
        
        if(node.left == null && node.right==null) return true;
        if(node.left!= null){
            if(node.left.val >= node.val 
               || node.left.val <= min
               || !func(node.left, node.val, min)) return false;
        }
        if(node.right!= null){
            if(node.right.val <= node.val 
               ||node.right.val >= max
               || !func(node.right, max, node.val)) return false;
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        return func(root, INF, -INF);
    }
}