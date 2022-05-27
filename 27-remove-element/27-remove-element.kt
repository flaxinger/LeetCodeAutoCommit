class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var idx = 0
        var cur = 0
        var N = nums.size
        
        while(cur < N){
            if(nums[cur]!=`val`){
                nums[idx] = nums[cur]
                idx++
            }
            cur++
        }
        return idx
    }
}