int commonCharacterCount(String s1, String s2) {
    StringBuilder string1 = new StringBuilder(s1);
        StringBuilder string2 = new StringBuilder(s2);
        
        
        int counter = 0;
        
        for(int i = 0; i < string1.length(); i++){
            for(int j = 0; j < string2.length(); j++){
                //System.out.println("String1: " + string1);
                //System.out.println("String2: " + string2 + "\n");
                //System.out.println("S1 char: " + string1.charAt(i));
                //System.out.println("S2 char: " + string2.charAt(j) + "\n");
                if(string1.charAt(i) == string2.charAt(j)){
                    string1.setCharAt(i, ' ');
                    string2.setCharAt(j, ' ');
                    //counter++;
                    
                    break;
                }
            }
        } 
        //System.out.println("-----------------------------------------------------------------------------------");
        
        for(int i = 0; i < string1.length(); i++){
            if(string1.charAt(i) == ' '){
                //System.out.println("String1: " + string1);
                //System.out.println("String2: " + string2 + "\n");
                counter++;
                //System.out.println("Increased\n");
            }
        }
        return counter;
}
