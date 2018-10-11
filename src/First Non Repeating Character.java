char firstNotRepeatingCharacter(String s) {
      int index = 0;
      //Arrays of int are always initialized to 0
      int[] letters = new int[26];
      int[] order = new int[26];
 
      //I think using getBytes() which returns the ASCII code is much more elegant than a classic for loop with charAt()     
      for(int i : s.getBytes()){
            letters[i-97]++;
            order[i-97] += index;
            index++;
      }
      
      int minindex = s.length();
      //I choose -2 to enjoy a single return statement as it is asked to return '_' if there is no non repeating character
      int result = -2;
 
      for(int i = 0; i < letters.length; i++){
            if(letters[i] == 1 && order[i] < minindex){
                  minindex = order[i];
                  result = i;
                  }
      }
      return (char) (result+97);
}
