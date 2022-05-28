class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum = 0
        var target = 0
        for(num in nums)
            sum+=num
        for(i in 0..nums.size)
            target+=i
        return target - sum
    }
}