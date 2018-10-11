/*Create a string reflexion (for char a -> z , b->y, m -> n) etc

*/

String reflectString(String inputString) {
String newstring = "";
    
    for(int i=0; i<inputString.length(); i++)
    {
       
            newstring += (char)(122-(int)inputString.charAt(i)+97);
        
      
        
    }
    return newstring;
}
