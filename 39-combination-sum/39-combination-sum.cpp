#import <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> ans;
    vector<int> can;
    int T, lim;
    
    void func(int idx, int sum, vector<int> v){
        
        if(idx == lim ) return;
        if(sum > T) return;
        if(sum == T){
            ans.push_back(v);
            return;
        }
        func(idx+1, sum, v);
        sum += can[idx];
        v.push_back(can[idx]);
        func(idx, sum, v);
        
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        can = candidates;
        lim = candidates.size();
        T = target;
        // vector<int> in;
        // for(int i =0; i < lim; i++){
        func(0, 0, vector<int>());
        // }
        return ans;
    }
};