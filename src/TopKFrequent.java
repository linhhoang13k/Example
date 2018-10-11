/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
*/

class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int key :map.keySet()){
            list.add(key);
        }
        Collections.sort(list, new Comparator<Integer>(){
           public int compare(Integer left, Integer right){
               return map.get(right)-map.get(left);
           }  
        });
        return list.subList(0, k);
    }
}