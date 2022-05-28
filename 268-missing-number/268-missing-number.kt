class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum = nums.sum()
        var target = 0
        for(i in 0..nums.size)
            target+=i
        return target - sum
    }
}