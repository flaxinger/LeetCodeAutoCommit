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

    int idx;
    int[] po;
    HashMap<Integer, Integer> ino = new HashMap<Integer, Integer>();
    
    private TreeNode build(int start, int end){
        
        if(start > end || idx == po.length) return null;        
        
        TreeNode cur = new TreeNode(po[idx++]);
        int cur_idx = ino.get(cur.val); 
        cur.left = build(start, cur_idx-1);
        cur.right = build(cur_idx+1, end);
        return cur;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for(int i = 0; i< inorder.length; i++){
            ino.put(inorder[i], i);
        }
        return build(0, inorder.length);
    }
}