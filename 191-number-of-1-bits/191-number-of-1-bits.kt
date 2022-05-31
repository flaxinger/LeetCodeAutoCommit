class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var cnt = 0
        var N = n.toLong()
        for(i in 0 until 32){
            if(N and (1L shl i) > 0)
                cnt++
        }
        return cnt
    }
}