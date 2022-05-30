class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        var isNegative = if((dividend>0 && divisor < 0) || (dividend<0 && divisor > 0) ) true else false
        var curDiv = Math.abs(divisor.toLong())
        var toAdd = 1L
        var ans = 0L
        var toDiv = Math.abs(dividend.toLong())
        while(curDiv < toDiv){
            curDiv = curDiv shl 1
            toAdd = toAdd shl 1
        }
        
        while(curDiv > 0){
            if(curDiv <= toDiv){
                ans+=toAdd
                toDiv -= curDiv
            }
            curDiv = curDiv shr 1
            toAdd = toAdd shr 1
        }
        ans = if(isNegative) -ans else ans
        ans = Math.min(Int.MAX_VALUE.toLong(), ans)
        ans = Math.max(Int.MIN_VALUE.toLong(), ans)
        return ans.toInt()
    }
}