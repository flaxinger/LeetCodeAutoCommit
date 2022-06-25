class Solution {
    fun checkPossibility(nums: IntArray): Boolean {
        var chance = true
        for(i in 1 until nums.size){
            if(nums[i-1]>nums[i]){
                if(chance && 
                        (i<nums.size-1 && nums[i-1] <nums[i+1] ||
                                i==1 || 
                                i == nums.size-1 || 
                                i>1 && nums[i] >= nums[i-2]
                                )){
                    chance = false
                }
                else return false
            }
        }
        return true
    }
}