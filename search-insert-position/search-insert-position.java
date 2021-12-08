class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int start = 0, end = nums.length-1, mid = 0;
        
        while(start+1 <end){
            
            mid = (start+end)/2;
            if(nums[mid] < target) start = mid;
            else end = mid;
            // System.out.println(start+" "+end);
        }

        if(nums[start]>=target) return start;
        if(start < nums.length-1 && nums[start+1] < target) return start+2;
        return start+1;
    }
}