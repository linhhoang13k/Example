HouseRobber{
int houseRobber(int[] nums) {
    int length = nums.length;
    if(length == 0)
        return 0;
    else if(length == 1)
        return nums[0];
    else if(length == 2)
        return Math.max(nums[0],nums[1]);
    int[] array = new int[length];
    array[0] = nums[0];
    array[1] = Math.max(nums[0],nums[1]);
    for(int i = 2 ; i < length ; i++){
        array[i] = Math.max(nums[i] + array[i-2],array[i-1]);
    }
    return array[length - 1];
}
}
