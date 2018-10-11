class ContainsCloseNumbers{
boolean containsCloseNums(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    for(int i = 0 ; i < nums.length ; i++){
        if(!map.containsKey(nums[i])){
            map.put(nums[i],i);
        }
        else if(Math.abs(i - map.get(nums[i])) <= k){
            return true;
        }
        else{
            map.put(nums[i],i);
        }
    }
    return false;
}
}

