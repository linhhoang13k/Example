class AreFollowingPatterns{

	boolean areFollowingPatterns(String[] strings, String[] patterns) {
    HashMap<String,String> leftRightMap = new HashMap<String,String>();
    HashMap<String,String> rightLeftMap = new HashMap<String,String>();
    for(int i = 0 ; i < strings.length ; i++){
        String first = strings[i];
        String second = patterns[i];
        if(leftRightMap.containsKey(first) && !second.equals(leftRightMap.get(first))){
            return false;
        }
        else{
            leftRightMap.put(first,second);
        }
        if(rightLeftMap.containsKey(second) && !first.equals(rightLeftMap.get(second))){
            return false;
        }
        else{
            rightLeftMap.put(second,first);
        }
    }
    return true;
}



}
