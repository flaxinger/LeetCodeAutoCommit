class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pattern = p.sortString()
        var N = s.length
        var M = p.length
        for(i in 0..N-M){
            if(s.substring(i, i+M).sortString()==pattern)
                result.add(i)
        }
        return result.toList()
    }
    
    fun String.sortString() = String(toCharArray().apply { sort() })
}