class Solution {
    
    
    
    public int maxProduct(int[] nums) {
        int N = nums.length, max = nums[0], s = 0, imax;
        int[] ori = nums.clone();
        
        
        for(int i = 0;i <= N; i++){
            if(i==N || ori[i] == 0){
                
                if(i < N && ori[i] == 0) max = Math.max(max, 0);
                if(s < N)  max = Math.max(max, nums[s]);
                
                for(int j = s+1; j < i; j++){
                    nums[j]*=nums[j-1];
                }
                for(int j = s; j < i; j++){
                    imax = Math.abs(nums[j]);
                    for(int k =j; k < i; k++){
                        imax = Math.max(imax, Math.abs(nums[k]));
                        max = Math.max(max, nums[k]);
                        nums[k]/=ori[j];
                    }
                    if(imax <= max) break;
                }
                s = i+1;
            }
        }
        
        return max;
        
    }
}