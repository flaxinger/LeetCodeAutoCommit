class Solution {
        
    
    fun numDecodings(s: String): Int {
        val N = s.length
        val dp = IntArray(N+1) { 0 }
        val decodeSet = mutableSetOf<String>()
        for(i in 1..26)
            decodeSet.add(i.toString())
    
        dp[0] = 1
        dp[1] = if(decodeSet.contains(s.substring(0, 1))) 1 else 0
        for(i in 2..N){
            if(decodeSet.contains(s.substring(i-1, i))){
                dp[i] += dp[i-1]                                                               
            }
            if(decodeSet.contains(s.substring(i-2, i))){
                dp[i] += dp[i-2]                                                               
            }
        }
        return dp[N]
    }
}