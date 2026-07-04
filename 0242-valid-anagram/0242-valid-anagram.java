class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        char[] CharArray1=s.toCharArray();
        char[] CharArray2=t.toCharArray();

        Arrays.sort(CharArray1);
        Arrays.sort(CharArray2);
        return Arrays.equals(CharArray1,CharArray2);
    }
}