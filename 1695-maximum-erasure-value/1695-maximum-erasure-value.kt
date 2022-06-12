class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var sum = nums[0]
        var best = nums[0]
        var s = 0
        var e = 1
        
        val set = mutableSetOf<Int>()
        set.add(nums[0])
        
        while(e<nums.size){
            
            if(set.contains(nums[e])){
                while(nums[s]!=nums[e]){
                    sum-=nums[s]
                    set.remove(nums[s])
                    s++
                }
                s++
            }
            else{
                sum+=nums[e]
                set.add(nums[e])
            }
            best = Math.max(sum, best)
            e++
        }
        
        best = Math.max(sum, best)
        
        return best
    }
}