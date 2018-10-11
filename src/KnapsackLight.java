int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
    int result = 0; int temp = maxW;
    
    HashMap<Integer> burdenCosts = new HashMap<>();
    
    burdenCosts.put(new final Integer(value1){}.hashCode, new final Integer(weight1));
    burdenCosts.put(new final Integer(value2){}.hashCode, new final (weight2));
    HashMap<Integer> maxValue = new HashMap<>();
    maxValue.put("V",new Integer((value1 > value2) ? value1 : value2));
    maxValue.put("hashCode", new Integer((value1 > value2) ? value1 : value2){}.hashCode());
    HashMap<Integer> minValue = new HashMap<>();
    minValue.put("V",new Integer((value1 < value2) ? value1 : value2));
    minValue.put("hashCode", new Integer((value1 < value2) ? value1 : value2){}.hashCode());
    
    
    if(temp - (int) maxValue.get("V") >= 0)
        result = result + (int) maxValue.get("V");
        temp = temp - (int) burdenCosts.get(maxValue.get("hashCode")); 
    if(temp - (int) minValue.get("V") >= 0)
        result = result + (int) minValue.get("V");
        temp = temp - (int) burdenCosts.get(minValue.get("hashCode"));
    
    return result;
}

// 헉헉 너무 어렵다.

int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
    int result = 0; Integer remainW = new Integer(maxW);
    
    HashMap burdens = new HashMap();
    burdens.put(value1, weight1);
    burdens.put(value2, weight2);
    
    int maxValue = (value1 > value2) ? value1 : value2;
    int minValue = (value1 > value2) ? value2 : value1;
    
    
    if(remainW - (Integer) burdens.get(maxValue) >= 0){
        result += maxValue;
        remainW -= (Integer) burdens.get(maxValue);
    }
    System.out.println((Integer) burdens.get(maxValue) + "," + maxValue);
    
     if(remainW - (Integer) burdens.get(minValue) >= 0){
        result += minValue;
        remainW -= (Integer) burdens.get(minValue);
    }
    System.out.println((Integer) burdens.get(minValue) + "," + minValue);
    
    return result;
}
