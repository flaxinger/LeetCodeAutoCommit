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
    
    vector<int> a;
    
    void trav(TreeNode* node){
        a.push_back(node->val);
        if(node->left) trav(node->left);
        if(node->right) trav(node->right);
    }
    int kthSmallest(TreeNode* root, int k) {
        trav(root);
        sort(a.begin(), a.end(), less<int>());
        return a[k-1];
    }
};