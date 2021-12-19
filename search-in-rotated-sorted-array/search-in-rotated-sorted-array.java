class Solution {
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length-1, mid = 0, cs = 0, N = nums.length;
        
        // find the starting point
        while(s+1 < e){
            mid = s+(e-s)/2;
            
            if(nums[e] < nums[mid])
                s = mid;
            else
                e = mid;
        }
        cs = nums[s]>nums[(s+1)%N]?(s+1)%N:s;
        s = cs;
        e = (cs+N-1)%N; 
        System.out.println(s+" "+e);
        while((s+1)%N!=e&&s!=e){
            mid = (s>e)?((e+N+s)/2)%N:s+(e-s)/2;
            if(nums[mid] <= target)
                s = mid;
            else
                e = mid;
        }
        s = (nums[(s+1)%N] == target)?(s+1)%N:s;
        return (nums[s%N] == target)?s%N:-1;
    }
}