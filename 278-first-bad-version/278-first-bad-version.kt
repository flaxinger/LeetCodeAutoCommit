/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        
        var start: Long = 0
        var end: Long = n.toLong()
        var mid: Long = 0
        while(start<=end){
            mid = (start+end)/2
            if(isBadVersion(mid.toInt()))
                end = mid-1
            else
                start = mid+1
        }
        
        return end.toInt()+1
	}
}