class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet hs = new HashSet();
        for(int i=0; i<nums.length; i++){
            if(hs.contains(nums[i])){
                return true;
            }else{
                hs.add(nums[i]);
            }
        }
        return false;
    }
}