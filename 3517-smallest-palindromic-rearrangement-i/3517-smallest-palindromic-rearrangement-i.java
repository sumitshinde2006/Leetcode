class Solution {
    public String smallestPalindrome(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            
            if (counts[i] % 2 != 0) {
                middle = String.valueOf(ch);
            }
            int halfCount = counts[i] / 2;
            for (int j = 0; j < halfCount; j++) {
                firstHalf.append(ch);
            }
        }
        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();

      
        return firstHalf.toString() + middle + secondHalf.toString();
    }
}
