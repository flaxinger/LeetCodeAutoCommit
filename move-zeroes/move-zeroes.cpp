class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int N = nums.size();
        for(int i = 0; i < nums.size(); i++){
            if(!nums[i]){
                nums.erase(nums.begin()+i);
                i--;
            }
        }
        while(nums.size() < N) nums.push_back(0);
      
    }
};