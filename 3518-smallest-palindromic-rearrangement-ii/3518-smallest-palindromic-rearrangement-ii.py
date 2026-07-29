import math
from collections import Counter

class Solution(object):
    def smallestPalindrome(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        n = len(s)
        counts = Counter(s)
        
        # 1. Separate characters for the first half and center element
        half_counts = {}
        mid = ""
        for char, count in counts.items():
            if count % 2 != 0:
                mid = char
            half_counts[char] = count // 2
            
        L = n // 2
        
        # 2. Compute total possible unique permutations (W) for the first half
        num = math.factorial(L)
        den = 1
        for count in half_counts.values():
            den *= math.factorial(count)
        W = num // den
        
        # If k is out of bounds, return an empty string
        if k > W:
            return ""
            
        # 3. Reconstruct the first half character by character (Greedy Approach)
        first_half = []
        sorted_chars = sorted(half_counts.keys())
        
        for pos in range(L):
            M = L - 1 - pos  # Remaining open slots after placing the current character
            
            for char in sorted_chars:
                if half_counts[char] > 0:
                    # Calculate permutations if 'char' is placed at 'pos'
                    # Equivalent to: (M)! / ( (c1)! * (c2)! * ... * (c_char - 1)! * ... )
                    P = W * half_counts[char] // (M + 1)
                    
                    if k > P:
                        k -= P  # Skip this character block
                    else:
                        first_half.append(char)
                        W = P  # Downscale total combinations for the next iteration
                        half_counts[char] -= 1
                        break
                        
        # 4. Synthesize the final symmetric string
        fh = "".join(first_half)
        return fh + mid + fh[::-1]
