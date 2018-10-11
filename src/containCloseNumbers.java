boolean containsCloseNums(int[] nums, int k) {
    int l=0;
    Map<Integer,Integer> map = new HashMap<>();
    
    for(int i=0;i<nums.length;i++) {
        if(map.containsKey(nums[i])) {
            l = (int)map.get(nums[i]);
            if((Math.abs(l-i) <= k))
                return true;
        }
        
        map.put(nums[i],i);
    }
    
    return false;
}
