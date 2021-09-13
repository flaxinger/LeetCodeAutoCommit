#include <bits/stdc++.h>

class Solution {
public:

    map<int,int> m;
    priority_queue<pair<int, int>> pq;
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int> ans;
        int N = nums.size(), t, M = 0;
        for(int i = 0; i < N; i++){
            m[nums[i]]++;                
            pq.push({m[nums[i]], nums[i]});
        }
    
        // for(int i = 0; i <= t; i++){
        //     if(arr[i]) pq.push({arr[i], i});
        // }
        
        while(k--){
            if(find(ans.begin(), ans.end(), pq.top().second)==ans.end())ans.push_back(pq.top().second);
            else k++;
            pq.pop();
        }
        return ans;
    }
};