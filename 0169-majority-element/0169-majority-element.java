// class Solution {
//     public int majorityElement(int[] nums) {
//         int n=nums.length;
//         int major=nums[0];

//         for(int i=0;i<n-1;i++)
//         {
//             int count = 0;
//             for (int j = 0; j < n; j++) {
//                 if (nums[j] == nums[i]) {
//                     count++;
//                 }
//             }
//             if(count >(n/2))
//             {
//                 major=nums[i];
//                 break;
//             }
//         }return major;
//     }
// }

class Solution {
    public int majorityElement(int[] nums) {
      int n=nums.length;
      Arrays.sort(nums);
      return nums[n/2];
    }
}