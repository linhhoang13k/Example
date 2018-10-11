/* Code Fights: Amazon
Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
*/

char firstNotRepeatingCharacter(String s) {
   
 int fIndex = 0;
 char[] arr = new char[26];
 byte[] foundList = new byte[26];
 for(int i=0; i<s.length(); i++){
   int ch = s.charAt(i)-'a';
   if(foundList[ch]==0){
     arr[fIndex]=(char)ch;
     fIndex++;
     foundList[ch]=1;
   }else{
     foundList[ch]=-1;
   }
 }
  for(int i=0; i<fIndex; i++){
    if(foundList[arr[i]]==1){
      return (char) (arr[i]+'a');
    }
  }
   return '_';
}
