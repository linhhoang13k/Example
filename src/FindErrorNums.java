/*
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Input: nums = [1,2,2,4]
Output: [2,3]
*/

class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
      int[] res = new int[2];
      HashSet<Integer> hs = new HashSet();
        for(int i=0; i<nums.length; i++){
            if(!hs.contains(nums[i])){
              hs.add(nums[i]);    
            }else{
                res[0] = nums[i];
            }
            
        }
        for(int i=1; i<=nums.length; i++){
            if(!hs.contains(i)){
                res[1]=i;
            }
        }
        return res;
    }
}