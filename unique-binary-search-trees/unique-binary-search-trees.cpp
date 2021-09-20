class Solution {
public:
    int dp[20];
    int numTrees(int n) {
        if(dp[n]) return dp[n];
        if(n==2) return 2;
        if(n==1) return 1;
        if(n==0) return 0;
        
        
        for(int i = 0; i < n; i++){
            dp[n] += max(numTrees(i),1) * max(numTrees(n-1-i), 1);
        }
        return dp[n];
    }
};