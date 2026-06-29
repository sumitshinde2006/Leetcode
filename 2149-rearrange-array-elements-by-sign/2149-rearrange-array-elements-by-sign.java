class Solution {
    public int[] rearrangeArray(int[] nums) {
         int n=nums.length;
         int[] sortt = new int[n]; 
        
        int positivePos = 0;
        int negativePos=1;
       
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
             sortt[positivePos] = nums[i];
             positivePos+=2;
            }
            else {
               sortt[negativePos] = nums[i];
                negativePos+=2;
            }
        }
          int[] sort = new int[sortt.length];
        for (int i = 0; i < sortt.length; i++) {
            sort[i] = sortt[i];
        }
       
        return sort;
    }
}