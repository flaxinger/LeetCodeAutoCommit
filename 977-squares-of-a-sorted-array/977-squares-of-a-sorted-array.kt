class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        var left = 0
        var right = 0
        var idx = 1
        var N = nums.size-1
        var min = Int.MAX_VALUE
        var ans = IntArray(nums.size)
        
        for(i in 0..N){
            nums[i] = Math.abs(nums[i])
            if(nums[i]<min){
                left = i
                min = nums[i]
            }
        }
        ans[0] = nums[left]*nums[left]
        right = left+1
        left--;
        
        while(idx<=N){
            if(right>N || (left>=0 && nums[left]< nums[right])){
                ans[idx] = nums[left]*nums[left]
                left--
            }else{
                ans[idx] = nums[right]*nums[right]
                right++
            }
            idx++
        }
              
        return ans
    }
}