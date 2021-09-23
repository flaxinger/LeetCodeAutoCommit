class Solution {
    public int maxProfit(int[] prices) {
        
        int ans=0, min=prices[0];
        for(int i =0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else{
                ans = Math.max(ans, prices[i]-min);
            }
        }
        return ans;
    }
}