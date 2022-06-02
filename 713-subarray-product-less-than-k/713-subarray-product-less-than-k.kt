class Solution {
    
    
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        
        var ans = 0
        for(i in 0 until nums.size){
            if(nums[i]<k){
                ans++
                for(j in i+1 until nums.size){
                    nums[i]*=nums[j]
                    if(nums[i]>=k)
                        break
                    ans++
                }
            }
        }
        return ans
    }
} 