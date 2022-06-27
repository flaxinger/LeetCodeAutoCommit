class Solution {
    fun minPartitions(n: String): Int {
        var c = '0'
        for(i in 0 until n.length){
            if(n[i]>c)
                c = n[i]
        }
        return Character.getNumericValue(c)
    }
}