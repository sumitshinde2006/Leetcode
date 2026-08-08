class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // last[j] stores the largest index in word1 that can match word2[j...m-1] strictly
        int[] last = new int[m];
        int word1Idx = n - 1;
        
        // Backward pass to find the maximum valid index in word1 for each suffix of word2
        for (int j = m - 1; j >= 0; j--) {
            while (word1Idx >= 0 && word1.charAt(word1Idx) != word2.charAt(j)) {
                word1Idx--;
            }
            last[j] = word1Idx;
            if (word1Idx >= 0) {
                word1Idx--; // Move to next available character in word1
            }
        }
        
        int[] result = new int[m];
        int j = 0;
        boolean canSkip = true; // Flag to track if we can still use the 1-character wildcard modification
        
        // Forward pass to greedily pick the lexicographically smallest sequence of indices
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                result[j] = i;
                j++;
            } else if (canSkip && (j == m - 1 || i < last[j + 1])) {
                // If characters don't match, we greedily change word1[i] to word2[j]
                // We can only do this if the remainder of word2 can be successfully matched
                result[j] = i;
                j++;
                canSkip = false; // Wildcard is now spent
            }
        }
        
        // If we matched all characters of word2, return the sequence; otherwise, it's invalid
        return j == m ? result : new int[0];
    }
}
