String getMonthName(int mo) {
    HashMap<Integer,String> hm =new HashMap<Integer,String>();  
    hm.put(1,"Jan"); 
    hm.put(2,"Feb");
    hm.put(3,"Mar");
    hm.put(4,"Apr");
    hm.put(5,"May");
    hm.put(6,"Jun");
    hm.put(7,"Jul");
    hm.put(8,"Aug");
    hm.put(9,"Sep");
    hm.put(10,"Oct");
    hm.put(11,"Nov");
    hm.put(12,"Dec");
    String s="invalid month";
    for (int key : hm.keySet()){
        if(key == mo) s= hm.get(key);
    }
    return s;
}
