class Solution {
    
    
    static final int INF = Integer.MAX_VALUE-1;
    
    public int jump(int[] nums) {
        int N = nums.length;
        int dp[] = new int[N];
        
        Arrays.fill(dp, INF);
        dp[N-1] = 0;
        for(int i = N-2;i >= 0; i--){
            for(int j = i+1; j <= Math.min(i+nums[i], N-1); j++){
                dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
                
        return dp[0];
    }
}