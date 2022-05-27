class Solution {
    fun search(nums: IntArray, target: Int): Int {
        
        var low = 0
        var end = nums.size-1
        while(low <= end){
            var mid = (low+end)/2
            if(nums[mid]<target)
                low = mid+1
            else
                end = mid-1
                
        }
        return if(low < nums.size && nums[low]==target) low else -1
    }
}