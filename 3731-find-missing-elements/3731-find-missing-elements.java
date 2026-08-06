class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        if(nums==null || nums.length==0)return new ArrayList<>();
       int min=nums[0];
       int max=nums[0];
       HashSet<Integer>List=new HashSet<>();
       for(int num:nums)
       {
        if(num<min)min=num;
        if(num>max)max=num;
        List.add(num);
       }
       ArrayList<Integer>Add=new ArrayList<>();
       for(int k=min;k<=max;k++)
       {
        if(!List.contains(k))
        Add.add(k);
       }
       return Add;
    }
}