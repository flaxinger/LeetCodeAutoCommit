class Solution {
    
    lateinit var nums: IntArray
    var N = 0
    
    fun findMin(nums: IntArray): Int {
        
        this.nums = nums
        this.N = nums.size
        var start = 0
        var end = N
        var mid: Int
        
        while(start<end){
            mid = (start+end)/2
            if(isMin(start))
                return nums[start]
            if(start!=mid && isMin(mid))
                return nums[mid]
            if(nums[start]>nums[mid]){
                end = mid-1
            }
            else{
                start = mid+1
            }
        }
        return nums[start.coerceAtMost(N-1)]
    }
    
    private fun isMin(idx: Int): Boolean {
        val before = (idx+N-1)%N
        val after = (idx+N+1)%N
        
        if(nums[idx]<nums[before] && nums[idx]<nums[after])
            return true
        return false
    }
    
    
}