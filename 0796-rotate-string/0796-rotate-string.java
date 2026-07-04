class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
        return false;
        int count=0;
       while(!s.equals(goal))
        {
            s=s.substring(1)+s.charAt(0);
            count++;

            if(count==s.length())
            {
                return false;
            }
        }return true;
    }
}