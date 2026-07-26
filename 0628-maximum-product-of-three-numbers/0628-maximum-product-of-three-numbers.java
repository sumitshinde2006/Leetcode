class Solution {
    public int maximumProduct(int[] nums) {
       Arrays.sort(nums);
        int total=nums.length;
        int prod=nums[total-1]*nums[total-2]*nums[total-3];
        int option2 = nums[0] * nums[1] * nums[total - 1];
        return Math.max(prod,option2);
        
    }
}