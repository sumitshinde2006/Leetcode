class Solution:
    def largestInteger(self, nums: list[int], k: int) -> int:
        n = len(nums)
        
        # Case 1: Subarrays of size 1
        if k == 1:
            counts = {}
            for x in nums:
                counts[x] = counts.get(x, 0) + 1
            singles = [x for x, freq in counts.items() if freq == 1]
            return max(singles) if singles else -1
            
        # Case 2: Subarray is the entire array
        if k == n:
            return max(nums)
            
        # Case 3: 1 < k < n
        # Only the first and last elements can be in exactly one subarray.
        # They must also be completely unique in the array to avoid appearing in other subarrays.
        ans = -1
        
        # Check first element
        if nums.count(nums[0]) == 1:
            ans = max(ans, nums[0])
            
        # Check last element
        if nums.count(nums[-1]) == 1:
            ans = max(ans, nums[-1])
            
        return ans
