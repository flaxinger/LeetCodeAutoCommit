class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val m = HashMap<Int, Int>()
        for(i in nums.indices){
            m[nums[i]] = i
        }
        for(i in nums.indices){
            if(m.containsKey(target-nums[i]) && m.get(target-nums[i])!! != i){
                return intArrayOf(i, m.get(target-nums[i])!!)
            }
        }
        return intArrayOf(1, 2)
    }
}