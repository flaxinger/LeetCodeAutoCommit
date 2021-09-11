class Solution {
public:
    
    vector<string> ans;

    void func(string a, int l, int r){
        
        if(!l && !r){
            ans.push_back(a);
            return;
        }
        if(l < r) func(a+')', l, r-1);
        if(l > 0) func(a+'(', l-1, r);
    }
    vector<string> generateParenthesis(int n) {
        func("", n, n);
        return ans;
    }
};