class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        return permute(nums.toMutableList()).map{i -> i.toList()}
    }
    
    fun permute(nums: MutableList<Int>): List<MutableList<Int>>{
        if(nums.size==1) return mutableListOf(nums.toMutableList())
        var ans = mutableSetOf<MutableList<Int>>()
        for(i in 0 until nums.size){
            var temp = nums[i]
            nums.removeAt(i)
            var minusOne = permute(nums)
            for(j in 0 until minusOne.size){
                minusOne[j].add(temp)
                ans.add(minusOne[j])
            }
            nums.add(i, temp)
        }
        return ans.toList()
    }
}