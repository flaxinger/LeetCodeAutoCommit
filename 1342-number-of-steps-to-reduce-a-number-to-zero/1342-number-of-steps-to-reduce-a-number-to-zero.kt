class Solution {
    
    fun numberOfSteps(num: Int): Int {
        var ans = 0
        var cur = num
        while(cur > 0){
            if(cur%2 == 0)
                cur/=2
            else
                cur--
            ans++
        }
        return ans
    }
}