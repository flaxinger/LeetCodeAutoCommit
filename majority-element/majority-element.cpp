class Solution {
public:
    map<int, int> m;
    
    int majorityElement(vector<int>& nums) {
        int best = 0; int ans = 0;
        for(int i=0; i < nums.size(); i++){
            m[nums[i]]++;
            if(m[nums[i]] > best){
                best = m[nums[i]];
                ans = nums[i];
            }
        }
        return ans;
    }
};