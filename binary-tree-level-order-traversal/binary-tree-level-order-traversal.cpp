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
    vector<vector<int>> ans;
    
    void trav(TreeNode* node, int lvl){
        
        if(ans.size() < lvl) ans.push_back(vector<int>());
        ans[lvl-1].push_back(node->val);
        if(node->left) trav(node->left, lvl+1);
        if(node->right) trav(node->right, lvl+1);
    }
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(!root) return ans;
        trav(root, 1);
        return ans;
    }
};