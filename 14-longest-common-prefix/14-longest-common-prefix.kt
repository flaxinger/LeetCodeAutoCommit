import kotlin.math.*

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        
        var s = strs[0]
        for(i in 1 until strs.size){
            var buff = ""
            for(j in 0 until min(strs[i].length, s.length)){
                if(strs[i][j] == s[j]){
                    buff+=strs[i][j]
                }
                else break
            }
            s = buff
        }
        return s
    }
}