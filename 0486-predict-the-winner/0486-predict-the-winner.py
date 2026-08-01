class Solution(object):
    def predictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        n = len(nums)
        # Even lengths are a guaranteed win for Player 1
        if n % 2 == 0:
            # Player 1 can force picking either all odd-indexed or all even-indexed elements
            return True
            
        dp = list(nums)
        
        # Bottom-up DP optimization
        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                dp[j] = max(nums[i] - dp[j], nums[j] - dp[j - 1])
                
        return dp[n - 1] >= 0
