class Solution {
public:
    
    int ans, N;
    string S, ori, com;
    
    void func(int idx){
        
        ori = "";
        int anchor;
        for(int i = idx; i < N; i++){
            ori+=S[i];
            anchor = idx + (i-idx+1)*2;
            if(anchor <= N){
                com = "";
                for(int j = anchor-1; j > i; j--){
                    com+=S[j];
                }
                if(com == ori){
                    // if(S=="adda") cout << "first: " << com << ' ' << ori<< endl;
                    ans++;
                }
            }
            anchor-=2;
            if(anchor <= N && anchor > idx){
                com = "";
                for(int j = anchor; j >= i; j--){
                    com+=S[j];
                }
                // if(idx == 0) cout << com << " " << ori<< endl;
                if(com == ori){
                    ans++;
                    // if(S=="adda") cout << "second: " << com << ' ' << ori << endl;
                }
            }
        }
    }
    
    
    
    int countSubstrings(string s) {
        
        S = s;
        N = s.length();
        ans+=N;
        
        for(int i =0; i < N; i++){
            func(i);    
        }
        return ans;
    }
};