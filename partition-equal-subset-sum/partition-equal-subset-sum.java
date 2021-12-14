class Solution {
    
    int half, N;
    int[] nums;
    Map<Integer, Boolean> vs;
    
    boolean dfs(int remain, int idx){
        if(remain == 0) return true;
        if(remain < 0 || vs.getOrDefault(remain, false)) return false;
        vs.put(remain, true);
        while(idx < N){
            if(dfs(remain-nums[idx], idx+1)){
                return true;
            }
            idx++;
        }
        return false;
    }
    
    
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        N = nums.length;
        half = 0;
        vs = new HashMap<>();
        for(int n: nums)
            half+=n;
        
        if(half%2>0) return false;
        half/=2;
        return dfs(half, 0);
    }
}