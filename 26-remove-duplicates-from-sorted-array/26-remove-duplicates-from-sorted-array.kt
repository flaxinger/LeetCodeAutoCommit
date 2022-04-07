class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        
        var idx = 0
        var cur = -101
        for(number in nums){
            if(number > cur){
                nums[idx]=number;
                cur = number
                idx++;
            }
        }
        return idx
    }
}