class ComposeRanges{
String[] composeRanges(int[] nums) {
    int length = nums.length;
    List<String> result = new ArrayList<String>();
    String min = null;
    int prev = 0;
    for(int i = 0 ; i < length ; i++){
        if(min == null){
            min = String.valueOf(nums[i]);  
        }
        else if(nums[i] != prev + 1 && prev == Integer.parseInt(min)){
            result.add(min);
            min = String.valueOf(nums[i]);
        }
        else if(nums[i] != prev + 1){
            result.add(min + "->" + String.valueOf(prev));
            min = String.valueOf(nums[i]);
        }
        prev = nums[i];
    }
                
    if(min != null && prev == Integer.parseInt(min)){
        result.add(min);
    }
    else if(min != null){
          result.add(min + "->" + String.valueOf(prev));  
    }
                
    
    return result.toArray(new String[0]);
}
}
