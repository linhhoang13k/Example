String simplifyPath(String path) {
    String[] direcs = path.split("/");
    ArrayList<String> list = new ArrayList<String>();
    Deque<String> stack = new ArrayDeque<String>();
    
    for(String y : direcs) {
        list.add(y);
    }
    
    
    
    
    for(String x : list) {
        if(x.equals(".")) {
            
        } else if(x.equals("..")) {
            if(stack.size() > 0) {
                stack.pop();
            }
           
        } else if(x.length() < 1) {
            
        }
        else {
            stack.push(x);
        }
        
        
    }
    
    StringBuilder sb = new StringBuilder();
    if(stack.size() == 0) {
        return "/";
    }
    
    for(String x : stack) {
        
        sb.insert(0,x);
        sb.insert(0,'/');
    }
    
    String result = sb.toString();
    
    
    return result;

}
