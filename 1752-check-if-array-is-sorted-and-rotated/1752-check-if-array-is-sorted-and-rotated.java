class Solution {
    public boolean check(int[] nums) {
    int first=nums[0];
    for(int i=0;i<nums.length-1;i++)
    {   
        if(nums.length==1)
            return true;
        if(nums[i]>nums[i+1])
        {
            for(int j=i+1;j<nums.length-1;j++)
            {
                if (nums[j] > nums[j + 1] || nums[j] > first) 
                        return false;
            }        
                if (nums[nums.length - 1] > first) 
                    return false; 
             return true;   
            
        }
    }
    return true;
    
    }
}