class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        
        var start = 0
        var end = nums.size-1
        var mid = 0
        while(start <= end){
            mid = (start+end)/2
            if(nums[mid]<target)
                start = mid+1
            else
                end = mid-1
        }
        return start
    }
}