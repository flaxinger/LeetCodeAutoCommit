class Solution {
public:
    
    int dp[60001];
    int singleNumber(vector<int>& nums) {
        
        int N = nums.size();
        for(int i = 0; i < N; i++){
            nums[i] += 30000;
            dp[nums[i]]++;
        }
        
        for(int i = 0; i < N; i++){
            if(dp[nums[i]] == 1) return nums[i]-30000;
        }
        return 0;
    }
};