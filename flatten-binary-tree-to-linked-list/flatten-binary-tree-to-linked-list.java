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
    
    TreeNode cur;
    boolean is_root;
    int count_right;
    public void add(int a){
        TreeNode temp = new TreeNode(a);
        // cur.val = 0;
        temp.right = cur.right;
        cur.right = temp;
        cur = temp;
    }
    public void trav(TreeNode a, boolean is_left){
        
        // System.out.println(a.val); 
        if(is_left){
            add(a.val);
            count_right++;
            // System.out.println(a.val);       
        }
        else if(count_right>0){
            count_right--;
        }
        else if(!is_root){
            if(cur.right != null && is_left == false) cur = cur.right;
            // System.out.println(a.val); 
        }
        
        if(is_root) is_root = false;
    
        if(a.left != null){
            trav(a.left, true);
            a.left = null;
        }
        if(a.right != null){
            trav(a.right, is_left);
        }
    }
    public void flatten(TreeNode root) {

        if(root == null) return;
        is_root = true;
        cur = root;
        trav(root, false);
    }
}