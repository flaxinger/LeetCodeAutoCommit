class Solution {
public:
    
    // vector<pair<int, int>> arr;
    //int arr[100000][2];
    int dp[101];
    vector<int> dailyTemperatures(vector<int>& temp) {
        vector<int> ans(temp.size(), 0);
        int N = temp.size(), cur;
        fill(dp, dp+101, -1);
        for(int i = 0; i < N; i++){
            cur = temp[i];
            if(dp[cur] < i){
                for(int j = i+1; j < N; j++){
                    if(cur < temp[j]){
                        ans[i] = j - i;
                        dp[cur] = j;
                        break;
                    }
                }
                if(ans[i]==0) dp[cur] = 100001;
                
            }
            else{
                if(dp[cur]==100001) ans[i] = 0;
                else ans[i] = dp[cur] - i;
            }
        } 
        return ans;
    }
};