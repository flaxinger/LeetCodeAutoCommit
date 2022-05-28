class Solution {
    fun missingNumber(nums: IntArray): Int {
        return IntRange(1, nums.size).sum() - nums.sum()
    }
}