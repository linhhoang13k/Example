Object fileNaming(String[] names) {

    List<String> result = new ArrayList<>();
    
    for( String s : names ){
        if(result.contains(s)){
            int i = 1;
            for(; result.contains(s+"("+i+")") ;i++){}
            s += "("+i+")";
        }
        result.add(s);
    }
    return result;
}
