String singkatan(String s1, String s2) {

    
   
        if(s1.contains(String.valueOf(s2.charAt(0))))
        {
            for (int index = s1.indexOf(s2.charAt(0));
                     index >= 0;
                     index = s1.indexOf(s2.charAt(0), index + 1))
             {
                 if(s2.contains(s1.substring(index,s1.length())))
                 {
                       return s1+s2.substring(s1.substring(index,s1.length()).length(),s2.length());
                 }
             }
      
        }
    
           
           return s1+s2;
}
