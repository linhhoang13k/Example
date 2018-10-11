boolean isLucky(int n) {
    List<Integer> first = new ArrayList<>();
    List<Integer> second = new ArrayList<>();
    int firstSum = 0;
    int secondSum = 0;
        
    String s = Long.toString(n);
    
    for(int i = 0; i < s.length()/2; i++){
        first.add(Integer.parseInt(Character.toString(s.charAt(i))));
    }
        
    for(int i = s.length()/2; i < s.length(); i++){
        second.add(Integer.parseInt(Character.toString(s.charAt(i))));
    }
        
    for(int i = 0; i < first.size(); i++){
        firstSum += first.get(i);
        secondSum += second.get(i);
    }
    
    return(firstSum == secondSum);
}
