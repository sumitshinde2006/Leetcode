class Solution(object):
    def missingMultiple(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # Convert list to set for O(1) average lookup time
        nums_set = set(nums)
        
        # Start checking multiples from 1 * k
        current_multiple = k
        
        # Find the first multiple not present in the set
        while current_multiple in nums_set:
            current_multiple += k
            
        return current_multiple
