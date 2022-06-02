class Solution {
    
    
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        
        if (k == 0 || k == 1) return 0

        var start = 0
        var end = 0
        var mul = 1
        var cnt = 0

        while (end < nums.size) {
            end++
            mul *= nums[end-1]
            while (mul >= k) {
                mul /= nums[start]
                start++
            }
            cnt += (end-start)
        }
        return cnt
    }
} 