class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int product = 1, zero = 0, nonzero = 0, mulzero =0;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i]){
                product *=nums[i];
                nonzero = 1;
            }
            else{
                if(zero) mulzero = 1;
                zero = 1;
                cout << mulzero << ' ' << zero << endl;
            } 
        }
        for(int i = 0; i < nums.size(); i++){
            if(nums[i]){
                if(zero){
                    nums[i] = 0;
                }   
                else nums[i] = product/nums[i];
            }
            else{
                if(nonzero){
                    if(mulzero) nums[i] = 0;
                    else nums[i] = product;
                }
                else nums[i] = 0;
            }
                
        }
        return nums;
    }
};