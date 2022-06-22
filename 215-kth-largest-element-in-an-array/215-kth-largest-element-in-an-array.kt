class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
              
        if(nums.size==1) return nums[0]
        var pivot = nums[0]
        var center = 1
        var idx = 1
        while(idx < nums.size){
            if(nums[idx]>pivot){
                swap(nums, center, idx)
                center++
            }
            idx++
        }
        center--
        swap(nums, center, 0)
        
        return if(center+1 == k) nums[center] 
        else if(k < center+1) findKthLargest(nums.copyOfRange(0, center), k)
        else findKthLargest(nums.copyOfRange(center+1, nums.size), k-(center+1))
    }
    
    fun swap(arr: IntArray, i: Int, j: Int){
        val t = arr[i]
        arr[i] = arr[j]
        arr[j] = t
    }
}