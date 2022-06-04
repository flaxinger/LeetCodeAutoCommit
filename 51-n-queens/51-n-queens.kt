class Solution {
    
    val result = mutableListOf<List<String>>()
    var N = 0
    fun solveNQueens(n: Int): List<List<String>> {
        N = n
        bruteforce(0, IntArray(N){0})
        return result.toList()
    }
    
    fun bruteforce(idx: Int, arr: IntArray){
        if(idx==N){
            result.add(createBoard(arr))
            return
        }
        var cont = true
        for(i in 0 until N){
            cont = true
            for(j in idx-1 downTo 0){
                if(arr[j]==i || (Math.abs(idx - j) == Math.abs(i - arr[j]))) 
                    cont = false
            }
            if(cont){
                arr[idx] = i
                bruteforce(idx+1, arr)
            }
        }
    }
    
    fun createBoard(arr: IntArray): List<String>{
        var result = mutableListOf<String>()
        for(i in 0 until arr.size){
            result.add(StringBuilder(".".repeat(arr.size-1)).insert(arr[i], 'Q').toString())
        }
        return result.toList();
    }
}