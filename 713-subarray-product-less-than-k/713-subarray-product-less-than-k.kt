class Solution {
    
    
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        
        var left = 0
        var product = 1
        var counter = 0

        for ((index, value) in nums.withIndex()) {
            product *= value
            while (product >= k&&left<=index) {
                product /= nums[left++]
            }
            counter += (index - left + 1)
        }
        return counter 
    }
} 