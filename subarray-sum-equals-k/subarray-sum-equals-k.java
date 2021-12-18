class Solution {
    
    
    public int subarraySum(int[] nums, int k) {
        int N = nums.length;
        int ans = 0;
        
        for(int i = 1; i < N; i++){
            nums[i] = nums[i-1]+nums[i];
        }
        
        for(int i = 0; i < N; i++){
            if(nums[i] == k) ans++;
            for(int j = i+1; j < N; j++){
                if(nums[j] == k) ans++;
                nums[j]-=nums[i];
            }
        }
        return ans;
        
    }
}