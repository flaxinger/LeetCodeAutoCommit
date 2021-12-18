class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int s=0, e = nums.length, mid, one, two;
        if(e==0) return new int[]{-1, -1};
        while(s+1<e){
            mid = s+(e-s)/2;
            if(nums[mid] < target)
                s = mid;
            else
                e = mid;
        }
        if(nums[0] == target) one = 0;
        else one = Math.min(s+1, nums.length-1);
        if(nums[one]!=target) return new int[]{-1,-1};
        s=0; e = nums.length;
        while(s+1<e){
            mid = s+(e-s)/2;
            if(nums[mid] <= target)
                s = mid;
            else
                e = mid;
        }
        return new int[]{one, s};
    }
}