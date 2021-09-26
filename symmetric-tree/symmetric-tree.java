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
    
    private boolean trav(TreeNode left, TreeNode right){
        
        if(left == null && right == null) return true;
        if((left == null && right != null) || (left != null && right == null)) return false;
        if(left.val != right.val) return false;
        // if(left.left.val != right.left.val) return false;
        // if(left.right.val != right.right.val) return false;
        
        boolean l = true, r = true;
        
        if(left.right != null || right.left !=  null) l = trav(left.right, right.left);
        if(left.left != null || right.right !=  null) r =trav(left.left, right.right);
        
        // System.out.printf("left is %s, right is %s", l, r);
        if(l && r) return true;
        else return false;
        
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return trav(root.left, root.right);
    }
}