class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if(needle.length == 0) return 0
        val N = haystack.length-needle.length
        val hayarr = haystack.toCharArray()
        val needarr = needle.toCharArray()
        for(i in 0..N){
            if(findShorterInLonger(hayarr, needarr, i))
                return i
        }
        return -1
    }
    
    fun findShorterInLonger(longer: CharArray, shorter: CharArray, start: Int): Boolean{
        var idx = start
        for(i in 0 until shorter.size){
            if(shorter[i]!=longer[idx++])
                return false
        }
        return true
    }
}