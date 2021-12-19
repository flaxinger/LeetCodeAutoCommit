class Solution {
    
    static final int POS = Integer.MAX_VALUE-1;
    public boolean canJump(int[] nums) {
        int N = nums.length;
        
        nums[N-1] = POS;
        for(int i = N-2;i >= 0; i--){
            for(int j = i+1; j <= Math.min(i+nums[i], N-1); j++){
                if(nums[j]==POS){
                    nums[i]=POS;
                    break;
                }
            }
            
        }
                
        return (nums[0]==POS)?true:false;
    }
}