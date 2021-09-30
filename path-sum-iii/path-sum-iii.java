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
    
    int ans = 0, T;
    
    void trav(TreeNode node, ArrayList<Integer> num){
        
        num.add(0);
        for(int i = 0; i < num.size(); i++){
            num.set(i, num.get(i)+node.val);
            if(num.get(i) == T){
                ans++;
            }
        }
        
        if(node.left!=null) trav(node.left, new ArrayList<>(num));
        if(node.right!=null) trav(node.right, new ArrayList<>(num));
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null) return 0;
        T = targetSum;
        trav(root, new ArrayList<Integer>());
        return ans;
    }
}