String reverseParentheses(String s) {

    
     int firstIndex = 0, secondIndex = 0;
        while (s.contains("(")){
           
           // one line using replace function to replace str between () with its reverse starting from the most inner () to the outer one
            s = s.replace("("+s.substring(s.lastIndexOf("(")+1, s.indexOf(")", s.lastIndexOf("(")))+")", 
            new StringBuffer(s.substring(s.lastIndexOf("(")+1, s.indexOf(")", s.lastIndexOf("(")))).reverse().toString());
           

    }
        return s;
}
