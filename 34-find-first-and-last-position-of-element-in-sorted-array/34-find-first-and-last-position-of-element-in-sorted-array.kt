class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var start = 0
        var end = nums.size-1
        var mid = 0
        var ans = intArrayOf(-1, -1)
        
        if(end==-1) return ans       
        
        while(start<=end){
            mid = (start+end)/2
            if(nums[mid]<target)
                start = mid+1
            else end = mid -1
        }
        if((end+1) != nums.size && nums[end+1]==target){
            ans[0]=end+1
            start = end
            end = nums.size-1
            while(start<=end){
                mid = (start+end)/2
                if(nums[mid]<=target)
                    start = mid+1
                else end = mid-1
            }
            ans[1] = end
        }
        return ans
    }
}