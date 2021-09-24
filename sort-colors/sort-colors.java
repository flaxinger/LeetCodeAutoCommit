class Solution {
    public void sortColors(int[] nums) {
        
        int[] cnt={0,0,0};
        for(int num: nums){
            cnt[num]++;
        }
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            while(cnt[idx]==0) idx++;
            cnt[idx]--;
            nums[i]=idx;
        }
    }
}