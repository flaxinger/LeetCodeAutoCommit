class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val MAX = Int.MAX_VALUE
        var ans = MAX
        var sum = nums[0]
        var start = 0
        var end = 1
        
        while(start < end){
            if(sum >= target){
                ans = Math.min(end-start, ans)
                sum-=nums[start++]
            }
            else if(end<nums.size){
                sum+=nums[end++]
            }
            else break;
        }
        return if(ans==MAX) 0 else ans
    }
}