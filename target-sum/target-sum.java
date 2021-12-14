class Solution {
    
    int ans, N, target;
    int[] nums;
    public void func(int sum, int idx){
        if(sum==target) ans++;
        else if(sum < target) return;
        
        while(idx < N){
            func(sum-nums[idx], idx+1);
            idx++;
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        N = nums.length;
        this.target = target;
        ans = 0;
        int total = 0;
        for(int i =0;i < N;i++){
            total+=nums[i];
            nums[i]*=2;
        }
        this.nums = nums;
        func(total, 0);
        return ans;
    }
}