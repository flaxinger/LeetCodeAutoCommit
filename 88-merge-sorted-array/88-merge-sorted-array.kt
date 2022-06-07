class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        for(i in m-1 downTo 0){
            nums1[i+n] = nums1[i]
        }
        var i = n
        var j = 0
        var idx = 0
        while(idx < nums1.size){
            if(j == nums2.size || i < nums1.size && nums1[i] < nums2[j]){
                nums1[idx] = nums1[i]
                i++
            }
            else{
                nums1[idx] = nums2[j]
                j++
            }
            idx++
        }
    }
}