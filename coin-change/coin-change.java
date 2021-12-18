class Solution {
    
    int[] dp, coins;
    static final int MAX = Integer.MAX_VALUE-1;
    static final int IMP = -1;
    
    public int func(int money){
        if(money<0) return IMP;
        if(money == 0) return 0;
        if(dp[money] != MAX) return dp[money];
        int sum, best = MAX, times;
        for(int c: coins){
            times = 1;
            while(times*c<=money){
                sum = func(money - c*times);
                if(sum!=IMP){
                    best = Math.min(sum+times, best);
                }
                times++;
            }
        }
        if(best == MAX){
            dp[money] = IMP;
            return IMP;
        }
        dp[money] = best;
        return best;
    }
    
    
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        this.coins = coins;
        Arrays.fill(dp, MAX);
        
        return func(amount);
        
    }
}