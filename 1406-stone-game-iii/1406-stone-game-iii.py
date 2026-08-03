class Solution(object):
    def stoneGameIII(self, stoneValue):
        """
        :type stoneValue: List[int]
        :rtype: str
        """
        n = len(stoneValue)
        # dp[i] represents the max relative score advantage from index i to the end
        # We add 3 extra elements to handle edge cases easily without out-of-bounds errors
        dp = [0] * (n + 3)
        
        # Build the solution from the end of the stone row back to the beginning
        for i in range(n - 1, -1, -1):
            max_diff = float('-inf')
            take_sum = 0
            
            # The current player can take 1, 2, or 3 stones
            for k in range(1, 4):
                if i + k <= n:
                    take_sum += stoneValue[i + k - 1]
                    # Score = stones taken minus the best the next player can do
                    max_diff = max(max_diff, take_sum - dp[i + k])
            
            dp[i] = max_diff
            
        # dp[0] contains Alice's ultimate score advantage at the start of the game
        alice_advantage = dp[0]
        
        if alice_advantage > 0:
            return "Alice"
        elif alice_advantage < 0:
            return "Bob"
        else:
            return "Tie"
