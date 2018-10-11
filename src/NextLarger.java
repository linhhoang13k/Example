int[] nextLarger(int[] a) {

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(-1);
    int [] result = new int [a.length];
    int max = 0;
    
    for(int x = 0; x < result.length; x++) {
        result[x] = -1;
    }
    
    for(int i = 0; i < a.length; i++) {
        
        for(int j = i+1; j < a.length; j++) {
            if(a[i] < a[j]) {
                result[i] = a[j];
                break;
            }
        }
    }
    
   
    return result;
}
