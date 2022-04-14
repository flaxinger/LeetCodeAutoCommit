class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        
        var idx = 0
        val N = matrix.size
        val M = matrix[0].size
        
        while(idx < N){
            if(target<matrix[idx][0]){
                idx--
                break
            }
            else if(target==matrix[idx][0]){
                return true
            }
            idx++
        }
        
        idx = idx.coerceAtMost(N-1)
        if(idx<0) return false
        
        var idy = 0
        while(idy < M){
            if(target<matrix[idx][idy]){
                return false
            }
            else if(target==matrix[idx][idy]){
                return true
            }
            idy++
        }
        
        return false
    
    }
}