class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int dup = 0;
      Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                dup = nums[i];
            }
        }
        return dup;
    }
}