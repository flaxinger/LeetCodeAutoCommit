/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int ans;
    
    void func(TreeNode* a, int d){
        
        if(d > ans) ans = d;
        
        if(a->left != nullptr){
            func(a->left, d+1);
        }
        if(a->right != nullptr){
            func(a->right, d+1);
        }
    }
    
    int maxDepth(TreeNode* root) {
        
        if(root == nullptr) return 0;
        func(root, 1);
        return ans;
    }
};