class Solution {
         
    fun point(a: Int, b: Int) = Math.max(0, a-b-1)
    
    fun numberOfArithmeticSlices(nums: IntArray): Int {
    
        var start = 0
        var end = 0
        var diff = 0
        var ans = 0
        
        while(end<nums.size){
            
            if(start==end){
                end++
                if(end==nums.size) return ans
                diff = nums[end-1] - nums[end]
            }
            else if(nums[end-1]-nums[end]==diff){
                ans+=point(end, start)       
                end++
            }
            else{
                end--
                start = end
            }
        }
        return ans
    }
    
}