int additionWithoutCarrying(int param1, int param2) {
    int temp = 0;

    String p1 = String.valueOf(param1);
    String p2 = String.valueOf(param2);
    
    StringBuilder sb = new StringBuilder("");
    
    int i = p1.length() - 1;
    int j = p2.length() - 1;
    
    while (i >= 0 || j >= 0) {
        if (i >= 0 && j >= 0) {
            temp = Integer.parseInt(String.valueOf(p1.charAt(i))) + Integer.parseInt(String.valueOf(p2.charAt(j)));
        } 
        else if (i >= 0 && j < 0) {
            temp = Integer.parseInt(String.valueOf(p1.charAt(i)));
        }
        else {
            temp = Integer.parseInt(String.valueOf(p2.charAt(j)));
        }
        
        temp = temp > 9 ? temp - 10 : temp;
        i--;
        j--;
        
        sb.append(String.valueOf(temp));
    }
    
    return Integer.parseInt(sb.reverse().toString());
}
