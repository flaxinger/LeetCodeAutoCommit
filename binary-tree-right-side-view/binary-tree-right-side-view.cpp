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
    
    vector<int> ans;
    int vs[100];
    void trav(TreeNode* node, int d){
        // if(right) 
        if(!vs[d]){
            ans.push_back(node->val);
            vs[d] = 1;
        }
        if(node->right) trav(node->right, d+1);
        if(node->left) trav(node->left, d+1);
        // if(node->left) trav(node->left, 0);
    }
    vector<int> rightSideView(TreeNode* root) {
        if(!root) return ans;
        trav(root, 0);
        return ans;
    }
};