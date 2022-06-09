class Solution {
    fun rob(nums: IntArray): Int {
        val N = nums.size
        val dp = Array(2) {IntArray(N) {-1}}
        if(N == 1) return nums[0]
        dp[0][0] = nums[0]
        dp[0][1] = Math.max(nums[1], nums[0])
        dp[1][0] = 0
        dp[1][1] = nums[1] 
        for(i in 2 until N-1){
            dp[0][i] = Math.max(nums[i]+dp[0][i-2], dp[0][i-1])
        }
        for(i in 2 until N){
            dp[1][i] = Math.max(nums[i]+dp[1][i-2], dp[1][i-1])
        }
        return Math.max(dp[0][N-2], dp[1][N-1])
    }
}