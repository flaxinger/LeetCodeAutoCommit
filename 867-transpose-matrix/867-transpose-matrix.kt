class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val result = Array(matrix[0].size, {i -> IntArray(matrix.size, {i-> 0})})
        for(i in 0 until result.size)
            for(j in 0 until result[0].size)
                result[i][j] = matrix[j][i]
        return result
    }
}