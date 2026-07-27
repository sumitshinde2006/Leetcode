class Solution {
    public int maxProduct(int[] nums) {
        int max=0;
        int max1=0;
     for(int i=0;i<nums.length;i++)
     {
        if(nums[i]>max)
        {
            max1=max;
            max=nums[i];
        }
         else if (nums[i]> max1) {
                max1 = nums[i];
            }
     }
         return(max - 1) * (max1 - 1);
        
    }
}