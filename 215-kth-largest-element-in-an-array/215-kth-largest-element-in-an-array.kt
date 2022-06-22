class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return find(nums, 0, nums.size, k)
    }
    
    fun find(nums: IntArray, start: Int, end: Int, k: Int): Int{
        
        if(start==end-1) return nums[start]
        var pivot = nums[start]
        var center = start+1
        var idx = start+1
        while(idx < end){
            if(nums[idx]>pivot){
                swap(nums, center, idx)
                center++
            }
            idx++
        }
        center--
        swap(nums, center, start)
        
        return if(center+1 == k) nums[center] 
        else if(k < center+1) find(nums, start, center, k)
        else find(nums, center+1, end, k)
    }
    
    fun swap(arr: IntArray, i: Int, j: Int){
        val t = arr[i]
        arr[i] = arr[j]
        arr[j] = t
    }
}