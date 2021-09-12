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
    int N;
    vector<int> V;

    TreeNode* root;
    
    TreeNode* make(int start, int end){
        
        
        if(start > end) return nullptr;
        int mid = start + (end-start)/2;
        TreeNode* a = new TreeNode(V[mid]);
        a->left = make(start, mid-1);
        a->right = make(mid+1, end);
        // nodemake(start, mid, a->left);
        // make(mid+1, end, a->right);
        return a;
    }
    
    
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if(nums.size() == 0) return nullptr;
        N = nums.size();
        V = nums;
        // vs = vector<int>(N, 0);
        return make(0, N-1);
    }
};