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
    
    void inv(TreeNode* t){
        
        if(t->left || t->right){
            TreeNode* temp = t->left;
            t->left = t->right;
            t->right = temp;
        }
        if(t->left){
            inv(t->left);
        }
        if(t->right){
            inv(t->right);
        }
    }
    
    TreeNode* invertTree(TreeNode* root) {
        
        if(!root) return nullptr;
        if(!root->left && !root->right) return root;
        
        inv(root);
        return root;
    }
};