class Solution {
    
    
    fun minOperations(nums: IntArray, x: Int): Int {
        val N = nums.size
        val map = mutableMapOf<Int, Int>()
        var sum = 0
        var MAX = Int.MAX_VALUE shr 4
        var ans = MAX
        for(i in 0 until N){
            sum += nums[i]
            map[sum] = i+1
        }
        sum = 0
        ans = Math.min(ans, map.getOrDefault(x, MAX))
        for(i in N-1 downTo 0){
            sum += nums[i]
            if(sum==x)
                ans = Math.min(ans, N-i)
            if(map.getOrDefault(x-sum, MAX)<i){
                ans = Math.min(ans, map.getOrDefault(x-sum, MAX)+N-i)
            }
        }
        return if(ans>=MAX) -1 else ans
    }
}