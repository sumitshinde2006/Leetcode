class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            int rightCharIdx = s.charAt(right) - 'a';
            count[rightCharIdx]++;
            
            while (count[rightCharIdx] > 2) {
                int leftCharIdx = s.charAt(left) - 'a';
                count[leftCharIdx]--;
                left++;
            }
            
             maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
