class Solution {
    fun maxScore(arr: IntArray, _k: Int): Int {
        val N = arr.size+1
        var k = _k+1
        val dp = IntArray(N){0}
        for(j in 1 until k){
            dp[j]= dp[j-1]+arr[j-1]
        }
        var ans = dp[k-1]
        
        for(i in 1 until k){
            for(j in 0 until k-i){
                dp[j] = dp[j]+arr[N-i-1]
            }
            ans = Math.max(ans, dp[k-i-1])
        }
        
        return ans;
    }
}