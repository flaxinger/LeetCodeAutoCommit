class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var cnt = 0
        for(i in 0 until 32){
            if(n.toLong() and (1L shl i) > 0)
                cnt++
        }
        return cnt
    }
}