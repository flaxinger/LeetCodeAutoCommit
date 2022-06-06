class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        return recursion(mutableListOf(), 0, nums)
    }
    
    fun recursion(cur: MutableList<Int>, idx: Int, nums: IntArray): List<List<Int>>{
        
        val ans = mutableSetOf<List<Int>>()
        if(idx==0)ans.add(listOf())
        if(idx>=nums.size) return ans.toList()
        
        val list1 = cur.toMutableList()
        list1.add(nums[idx])
        ans.add(list1.toList())
        ans.addAll(recursion(list1, idx+1, nums))
        ans.addAll(recursion(cur, idx+1, nums))
        
        return ans.toList()
        
    }
}