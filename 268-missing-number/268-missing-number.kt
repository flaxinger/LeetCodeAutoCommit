class Solution {
    fun missingNumber(nums: IntArray): Int {
        var set = nums.toSet()
        for(i in 0..nums.size)
            if(!set.contains(i))
                return i
        return 0
    }
}