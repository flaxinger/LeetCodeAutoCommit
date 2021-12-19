class Solution {
    
    

    
    public void nextPermutation(int[] nums) {
        int idx = nums.length-1;
        int cs = idx, tmp=0;
        
        while(cs >= 0){
            idx = cs;
            tmp = -1;
            while(idx < nums.length){
                if(nums[idx] > nums[cs]){
                    if(tmp >= 0 && nums[idx] <= nums[tmp])
                        tmp = idx;
                    else if(tmp == -1)
                        tmp = idx;
                } 
                idx++;
            }
            if(tmp< nums.length && nums[(tmp<0)?nums.length-1:tmp] > nums[cs]) break;
            cs--;
        }
        idx = tmp;
        if(cs < 0){
            Arrays.sort(nums);
            return;
        }
        
        tmp = nums[idx];
        nums[idx] = nums[cs];
        nums[cs] = tmp;
        
        Arrays.sort(nums, cs+1, nums.length);
    }
}