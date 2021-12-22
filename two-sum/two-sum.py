class Solution(object):
    def twoSum(self, nums, target):
        
        
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        ans=[]
        count=0
        yes=False
        for number in nums:
            secondcount=0
            for another in nums:
                if count != secondcount:
                    if (number+another==target) and (len(ans)<2):
                        ans.append((count))
                        ans.append((secondcount))
                        yes=True
                secondcount+=1
                if (yes):
                    break
            count+=1
            if (yes):
                break
        return ans