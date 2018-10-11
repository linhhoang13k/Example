int kthLargestElement(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1,new Comparator<Integer>(){
        public int compare(Integer a, Integer b) {
            if(a > b) {
                return -1;
            } else if (a.equals(b)) {
                return 0;
            } 
            return 1;
        }
    });
    
    for(int i = 0; i < nums.length; i++) {
        maxHeap.add(nums[i]);
    }
    
    for(int j = 0; j < k-1; j++) {
        maxHeap.remove();
    }
    
    return maxHeap.peek();
}
