class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        ansind=0
        anscount=0
        double=False
        longest=0
        
        for letter in range(len(s)):
            
            count=1
            while letter+1-count>=0 and letter+count<len(s) and s[letter+1-count]==s[letter+count]:
                if count*2>longest:
                    ansind=letter
                    anscount=count
                    double=True
                    longest=count*2
                count+=1
                
            count=1
            while letter-count>=0 and letter+count<len(s) and s[letter+count]==s[letter-count]:
                if count*2+1>longest or (anscount==count and double==True):
                    double=False
                    ansind=letter
                    anscount=count
                    longest=count*2+1
                count+=1
                
        if double:
            return s[ansind+1-anscount:ansind+anscount+1]
        elif ansind==0 and anscount==0:
            return s[0]
        else:
            return s[ansind-anscount:ansind+anscount+1]
