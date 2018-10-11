/*
Tom goes to a train station every afternoon to watch the 2pm train go. He has noted that the number of wagons the train has is always an odd number, and that every day the number of wagons the train has increases by 2, starting with 1 wagon on the first day of each month.

Thus, on the 1st day of each month the train goes with a single wagon, on the 2nd day it has 3 wagons, the next day it has 5 wagons, and so on.

The routine of counting the wagons comforts Tom, and he never misses a day. But on the dayth day of a certain month he will have to go to a camp that will last for n days. During these days, Tom will not be able to come and count the wagons.

Given the day, the month and the number n, your task is to calculate the number of wagons Tom will miss. Assume that this and the following years are both non-leap.

Example

For month = 1, day = 1 and n = 1, the output should be
toms_wagons(month, day, n) = 1.

Tom will miss only the train that leaves on the first of January. This train will have only one wagon, so the answer is 1.

For month = 3, day = 2 and n = 4, the output should be
toms_wagons(month, day, n) = 24.

Tom will miss 4 March days, from the 2nd to the 5th. Thus, he will miss 3 + 5 + 7 + 9 = 24 wagons.
*/


int toms_wagons(int month, int day, int n) {

    int wagonsmissed=0;
    int monthdaysval=monthdays(month);
   // System.out.println(monthdaysval);
    
    for(int i=0; i<n; i++)
    {
       
        monthdaysval = monthdays(month);
        
        System.out.println("Month is "+month);
        System.out.println("Day is "+(day+i));
        System.out.println("Month days  "+monthdaysval);
        month = currentmonth( (day+i),month);
        
        wagonsmissed += misswagons((day+i),month);
        month = currentmonth( (day+i),month);
        System.out.println("Missed wagons are "+wagonsmissed);
        System.out.println("Month after next day is "+currentmonth( (day+i),month));
    }
    
    return wagonsmissed;
}


   int monthdays(int month)
   {
       if(month==2)
           return 28;
       else if(month%2==1 || month==8)
           return 31;
       else
           return 30;
   }

  int misswagons(int currentday, int cm)
  {
      int wagons= 1 + 2*(currentday-1);
      return wagons;
  }

  int currentmonth(int currentday, int currentmonth)
  {
      if(currentday>monthdays(currentmonth))
      {
          currentmonth++;
      }
      return currentmonth;
  }