class Solution {
    
    
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        
        var ans = 0
        val N = nums.size-1
        var cur = 0
        for(i in 0..N){
            if(nums[i]<k){
                ans++
                cur=nums[i]
                for(j in i+1..N){
                    cur*=nums[j]
                    if(cur>=k)
                        break
                    ans++
                }
            }
        }
        return ans
    }
} 