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
    int ans =0;
    private int trav(TreeNode node){
        
        int l = 0, r = 0;
        if(node.left!=null) l = trav(node.left);
        if(node.right!=null) r = trav(node.right);
        ans = Math.max(l+r, ans);
        return Math.max(l+1, r+1);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        trav(root);
        return ans;
    }
}