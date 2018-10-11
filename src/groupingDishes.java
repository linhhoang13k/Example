class GroupingDishes{
String[][] groupingDishes(String[][] dishes) {
    String key = null, value = null;
    TreeMap<String,List<String>> map = new TreeMap<String,List<String>>();
    for(int i = 0 ; i < dishes.length ; i++){
        for(int j = 0 ; j < dishes[i].length ; j++){
            if(j == 0){
                value = dishes[i][j];
            }
            else{
                key = dishes[i][j];
                if(map.containsKey(key)){
                    List<String> t = map.get(key);
                    t.add(value);
                    map.put(key,t);
                }
                else{
                    List<String> temp = new ArrayList<String>();
                    temp.add(value);
                    map.put(key,temp);
                }
            }
        }
    }
        List<String[]> result = new ArrayList<String[]>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            key = entry.getKey();
            List<String> temp = entry.getValue();
            if(temp.size() >= 2){
                Collections.sort(temp);
                temp.add(0,key);
                result.add(temp.toArray(new String[0]));
            }                
        }
        
        String[][] resultArray = new String[result.size()][];
        int i = 0;
        for(String[] list : result){
            resultArray[i++] = list;
        }
        return resultArray;
    }

}
