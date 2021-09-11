class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> a;
        int N = nums.size();
        
        for(int i = 0; i < 1<< N; i++){
            a.clear();
            for(int j = 0; j < N; j++){
                if(i & 1<<j) a.push_back(nums[j]);
            }
            ans.push_back(a);
        }
        return ans;
    }
};