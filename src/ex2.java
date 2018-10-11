int centuryFromYear(int year) {
   int valueToCheck = year/100;

   if(year % 100 == 0){
      return valueToCheck;
   }

   return (int) Math.floor(valueToCheck) + 1;
}
