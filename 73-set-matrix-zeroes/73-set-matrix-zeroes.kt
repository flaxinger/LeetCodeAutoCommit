class Solution {
    
    fun setZeroes(matrix: Array<IntArray>): Unit {
        
        val N = matrix.size
        val M = matrix[0].size
        val arr = mutableListOf<Pair>()
        for(i in 0 until N){
            for(j in 0 until M){
                if(matrix[i][j]==0){
                    arr.add(Pair(i, j));
                }
            }
        }
        for(pair in arr){
            for(i in 0 until N)
                matrix[i][pair.y] = 0
            for(j in 0 until M)
                matrix[pair.x][j] = 0
        }
    }
    
    class Pair(
        val x: Int,
        val y: Int
    )
}