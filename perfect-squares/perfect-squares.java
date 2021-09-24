class Solution {
    
    int[] element = new int[200];
    int[] dp = new int[40001];   
    
    private int trav(int num){
        
        if(num == 0) return 0;
        if(dp[num] != 0) return dp[num];
        
        int result = 80000;
        for(int i = 199; i >=0; i--){
            if(num-element[i] >= 0) result = Math.min(result, trav(num-element[i])+1);
        }
            
        return dp[num] = result;
    }
    
    
    public int numSquares(int n) {
        
        for(int i = 1; i <=200; i++){
            element[i-1] = i*i;
        }
        // fill(dp, -1);
        // dp[0] = 0;
        return trav(n);
        
    }
}