class Solution {
    public int missingNumber(int[] nums) {
        int count=0;
        int sum=0;
        int missing=-1;
        for(int i=0;i<nums.length;i++)
        {
            count++;
            sum+=nums[i];

        }
        missing=count*(count+1)/2-sum;
        return missing;
    }
}