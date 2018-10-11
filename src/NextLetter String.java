/* Given a string, replace each its character by the next one in the English alphabet (z would be replaced by a).

Example

For inputString = "crazy", the output should be
alphabeticShift(inputString) = "dsbaz".
*/

String alphabeticShift(String inputString) {
String news="";
    for(int i=0; i<inputString.length(); i++)
    {
        if(((int)(inputString.charAt(i))+1) != 123)
        {
        news += (char)( (int)(inputString.charAt(i))+1);
        }
        else
        {
             news += "a";
        }
    }
    return news;
}
