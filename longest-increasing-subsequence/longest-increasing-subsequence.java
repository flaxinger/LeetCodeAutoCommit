class Solution {
    
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        int N = nums.length;
        for(int i = 0; i < N; i++)
            dp[i] = 1;
        
        int ans = 0;
        for(int i = 0; i < N; i++){
            for(int j = i-1; j >=0; j--){
                if(nums[i]>nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}