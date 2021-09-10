#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int s_count;
    int e_count;
    int se[26][2];
    vector<int> partitionLabels(string s) {
        vector<int> ans;
        int l = s.length();
        // 로컬에서는 되는데 외 안돼?
        // fill(&se[0][0], &se[0][0]+sizeof(se), -1);
        for(int i = 0; i < 26; i++){
            se[i][0] = -1; se[i][1] = -1;
        }
        for(int i = 0; i < l; i++){
            if(se[s[i]-'a'][0] == -1) se[s[i]-'a'][0] = i;
            se[s[i]-'a'][1] = i;
        }

        for(int i = 0; i < l; i++){
            if(se[s[i]-'a'][0] == i) s_count++;
            if(se[s[i]-'a'][1] == i) e_count++;
            if(s_count == e_count){
                ans.push_back(i+1 );            
            }
        }
        for(int i = ans.size()-1; i > 0; i--){
            ans[i] -= ans[i-1];
        }
        return ans;
    }
};