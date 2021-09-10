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
    TreeNode* root = new TreeNode();
    
    void traverse(TreeNode* a, TreeNode* b, TreeNode* c){
        
        // if(a.val != nullptr) 
        c->val += a->val;
        // if(b.val != nullptr) 
        c->val += b->val;
        
        if(a->left != nullptr || b->left != nullptr){
            c->left = new TreeNode();
            if(a->left == nullptr) a->left = new TreeNode();
            if(b->left == nullptr) b->left = new TreeNode();
            traverse(a->left, b->left, c->left);
        }
        if(a->right != nullptr || b->right != nullptr){
            c->right = new TreeNode();
            if(a->right == nullptr) a->right = new TreeNode();
            if(b->right == nullptr) b->right = new TreeNode();
            traverse(a->right, b->right, c->right);
        }
    }
    
    TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
        
        if(root1 == nullptr && root2 == nullptr) return nullptr;
        if(root1 == nullptr) root1 = new TreeNode();
        if(root2 == nullptr) root2 = new TreeNode();
        traverse(root1, root2, root);
        return root;
    }
};