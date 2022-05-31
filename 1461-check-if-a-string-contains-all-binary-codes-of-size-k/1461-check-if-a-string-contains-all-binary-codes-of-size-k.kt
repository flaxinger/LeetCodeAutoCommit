class Solution {
    
    val set = mutableSetOf<String>()
    
    fun hasAllCodes(s: String, k: Int): Boolean {
        for(i in 0..s.length-k){
            set.add(s.substring(i, i+k))
        }
        return set.size == Math.pow(2.0, k.toDouble()).toInt()
    }
}