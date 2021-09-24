/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int P, Q;
    TreeNode ans = null;
    private int trav(TreeNode node){
        int result = 0;
        if(ans!=null) return 0;
        if(node.val == P) result |= 1 << 1;
        if(node.val == Q) result |= 1 << 0;
        
        if(node.left != null) result |= trav(node.left);
        if(node.right != null) result |= trav(node.right);
        
        if(ans== null && (result & 1 << 0)>0 && (result & 1 << 1)>0) ans = node;
        return result;
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        P = p.val;
        Q = q.val;
        trav(root);
        return ans;
    }
}