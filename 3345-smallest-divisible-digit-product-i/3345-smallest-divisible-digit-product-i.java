class Solution {
    public int smallestNumber(int n, int t) {
        while(true)
        {
            int digi=1;
            int temp=n;
            while(temp>0)
            {
                digi*=temp%10;
                temp/=10;

            }
            if(digi%t==0)
            return n;
            n+=1;
        }
    }
}