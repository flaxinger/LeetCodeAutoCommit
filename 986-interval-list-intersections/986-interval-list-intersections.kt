class Solution {
    fun intervalIntersection(fL: Array<IntArray>, sL: Array<IntArray>): Array<IntArray> {
        
        val ans = mutableListOf<IntArray>()
        var i = 0
        var j = 0
        var N = fL.size
        var M = sL.size
        
        while(i < N && j < M){
            when{
                fL[i][1]==sL[j][1] -> {
                    ans.add(intArrayOf(Math.max(sL[j][0], fL[i][0]), fL[i][1]))
                    i++
                    j++
                }
                fL[i][1]<sL[j][1] -> {
                    if(sL[j][0] <= fL[i][1]){
                        ans.add(intArrayOf(Math.max(sL[j][0], fL[i][0]), fL[i][1]))
                    }
                    i++
                }
                sL[j][1]<fL[i][1] -> {
                    if(fL[i][0] <= sL[j][1]){
                        ans.add(intArrayOf(Math.max(fL[i][0], sL[j][0]), sL[j][1]))
                    }
                    j++
                }
            }
        }
        return (ans as List<IntArray>).toTypedArray()
    }
}