class Solution {
    
    fun numberOfSteps(num: Int): Int {
        var arr = Array(num+1, {i-> i})
        for(i in 0..num){
            if(i*2 <= num){
                arr[i*2] = Math.min(arr[i]+1, arr[i*2])
            }
            if(i < num){
                arr[i+1] = Math.min(arr[i]+1, arr[i+1])
            }
        }
        return arr[num]
    }
}