class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size-1
        var mid = 0
        
        // find nums[0]
        while(start<=end){
            mid = (start+end)/2
            if(nums[0] <= nums[mid])
                start = mid+1
            else
                end = mid-1
        }
        if(start == 0) start = nums.size-1
        if(target >= nums[0]){
            end = start-1
            start = 0
        } else end = nums.size-1
        while(start<=end){
            mid = (start+end)/2
            if(target > nums[mid])
                start = mid+1
            else
                end = mid-1
        }
        return if(start<nums.size && nums[start]==target) start else -1
    }
}