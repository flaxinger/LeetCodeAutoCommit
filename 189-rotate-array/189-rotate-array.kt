class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var nk = k%nums.size
        nums.reverse()
        nums.reverse(0, nk)
        nums.reverse(nk, nums.size)
    }
    public fun IntArray.reverse(fromIndex: Int, toIndex: Int): Unit {
        val midPoint = (fromIndex + toIndex) / 2
        if (fromIndex == midPoint) return
        var reverseIndex = toIndex - 1
        for (index in fromIndex until midPoint) {
            val tmp = this[index]
            this[index] = this[reverseIndex]
            this[reverseIndex] = tmp
            reverseIndex--
        }
    }
}