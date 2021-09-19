class Solution {
public:
    int a[100001];
    int findDuplicate(vector<int>& nums) {
        for(int i = 0; i< nums.size(); i++){
            a[nums[i]]++;
            if(a[nums[i]]>1) return nums[i];
        }
        return 1;
    }
};