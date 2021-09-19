class Solution {
public:
    
    int vs[1000];
    map<string, vector<string>> m;
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        vector<string> k;
        string kkey;
        for(int i = 0; i < strs.size(); i++){
            kkey = strs[i];
            sort(kkey.begin(), kkey.end());
            m[kkey].push_back(strs[i]);
            if(m[kkey].size() == 1) k.push_back(kkey);
        }
        for(int i =0; i < k.size(); i++){
            ans.push_back(m[k[i]]);
        }
        return ans;
    }
};