class Solution {
    fun findPeakElement(nums: IntArray): Int {
        
        var start = 0
        var end = nums.size-1
        var mid = 0
        
        while(start <= end){
            mid = (start+end)/2
            
            if(isPeak(nums, mid))
                return mid
            else if((mid>0 && (nums[mid]-nums[mid-1])>0) || 
                    ((mid < nums.size-1) && (nums[mid+1]-nums[mid]) > 0))
                start = mid+1
            else end = mid-1
        }
        
        return start
    }
    
    fun isPeak(nums:IntArray, idx: Int): Boolean{
        if(idx!= 0 && nums[idx] < nums[idx-1])
            return false
        if(idx!=nums.size-1 && nums[idx] < nums[idx+1])
            return false
        return true
    }
}