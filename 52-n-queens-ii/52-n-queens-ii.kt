class Solution {
    
    var N = 0
    var ans = 0
    
    fun totalNQueens(n: Int): Int {
        N = n
        bruteforce(0, IntArray(N){0})
        return ans    
    }
    
    fun bruteforce(idx: Int, arr: IntArray){
        if(idx==N){
            ans++
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
}
