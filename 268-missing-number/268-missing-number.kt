class Solution {
    fun missingNumber(nums: IntArray): Int {
        var target = 0
        for(i in 0..nums.size)
            target+=i
        return target - nums.sum()
    }
}