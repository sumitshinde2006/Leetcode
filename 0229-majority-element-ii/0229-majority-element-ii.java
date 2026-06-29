class Solution {
    public List<Integer> majorityElement(int[] nums) {
       List<Integer> major = new ArrayList<>();

        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            boolean alreadyProcessed = false;
            for (int k = 0; k < i; k++) {
                if (nums[k] == nums[i]) {
                    alreadyProcessed = true;
                    break;
                }
            }
             if (!alreadyProcessed) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    }
                }

            if(count >(n/3))
            {
               major.add(nums[i]);
            }
        }
    }return major;

    }
}