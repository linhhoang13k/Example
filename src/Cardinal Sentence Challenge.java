String ns="";
    String x="";
    String cardinal(String n) {
    String num="";
    if(n.equals("0"))
    {
        return "zero";
    }
        if(n.length() ==1)
        {
            return fornumbers(0,n);
        }
    int length= n.length();
    
        for(int i=0; i<length; i++)
        {
           if( (length-i) == 3 && n.charAt(i) !='0' && (n.charAt(i+1)!='0' || n.charAt(i+2)!='0') )
           {
               ns += fornumbers((i),n) +" hundred and ";
           }
            else if((length-i) == 3 && n.charAt(i) !='0' && n.charAt(i+1)=='0')
            {
                 ns += fornumbers((i),n) +" hundred";
            }
           if( (length-i) == 4 && n.charAt(i) !='0')
           {
               ns += fornumbers((i),n) +" thousand ";
           }
            if( (length-i) == 5 && n.charAt(i) !='0')
           {
               ns += dekades(n.charAt(i),n.charAt(i+1)) +" thousand ";
               i++;
           }
             if( (length-i) == 6 && n.charAt(i) !='0'  && n.charAt(i+1)!='0')
           {
               ns +=fornumbers((i),n) +" hundred and "+ dekades(n.charAt(i+1),n.charAt(i+2)) +" thousand ";
               i+=2;
           }
            else if((length-i) == 6 && n.charAt(i) !='0' && n.charAt(i+1)=='0')
            {
               ns +=fornumbers((i),n) +" hundred "+ dekades(n.charAt(i+1),n.charAt(i+2)) +" thousand ";
               i+=2; 
            }
            if( (length-i) == 7 && n.charAt(i) !='0')
            {
                ns +=fornumbers(i,n)+" million ";
            }
            if( (length-i) == 8 && n.charAt(i) !='0')
            {
                ns +=dekades(n.charAt(i),n.charAt(i+1)) +" million ";
                i++;
            }
             if( (length-i) == 9 && n.charAt(i) !='0'  && n.charAt(i+1)!='0')
           {
               ns +=fornumbers((i),n) +" hundred and "+ dekades(n.charAt(i+1),n.charAt(i+2)) +" million ";
               i+=2;
           }
             else if((length-i) == 9 && n.charAt(i) !='0' && n.charAt(i+1)=='0')
             {
                ns +=fornumbers((i),n) +" hundred "+ dekades(n.charAt(i+1),n.charAt(i+2)) +" million ";
               i+=2; 
             }
            if( (length-i) == 10 && n.charAt(i) !='0')
            {
                ns +=fornumbers(i,n)+" billion ";
            }
            if( (length-i) == 11 && n.charAt(i) !='0')
            {
                ns +=dekades(n.charAt(i),n.charAt(i+1)) +" billion ";
                i++;
            }
            if( (length-i) == 12 && n.charAt(i) !='0'  && n.charAt(i+1)!='0')
           {
               ns +=fornumbers((i),n) +" hundred and "+ dekades(n.charAt(i+1),n.charAt(i+2)) +" billion ";
               i+=2;
           }
            else if((length-i) == 12 && n.charAt(i) !='0' && n.charAt(i+1)=='0')
             {
                ns +=fornumbers((i),n) +" hundred "+ dekades(n.charAt(i+1),n.charAt(i+2)) +" billion ";
               i+=2; 
             }
            
            if( (length-i) == 13 && n.charAt(i) !='0')
            {
                ns +=fornumbers(i,n)+" trillion ";
            }
            if( (length-i) == 14 && n.charAt(i) !='0')
            {
                ns +=dekades(n.charAt(i),n.charAt(i+1)) +" trillion ";
                i++;
            }
             if( (length-i) == 15 && n.charAt(i) !='0' && n.charAt(i+1) !='0')
           {
               ns +=fornumbers((i),n) +" hundred and "+ dekades(n.charAt(i+1),n.charAt(i+2)) +" trillion ";
               i+=2;
           }
            else if( (length-i) ==15 && n.charAt(i+1) =='0')
            {
                 ns +=fornumbers((i),n) +" hundred "+ dekades(n.charAt(i+1),n.charAt(i+2)) +" trillion ";
               i+=2;
            }
           if((length-i)==2 && length>3)
           {
               ns += dekades(n.charAt(i),n.charAt(i+1));
           }
            else if( (length-i)==2 && length<3)
            {
                 ns += dekades(n.charAt(i),n.charAt(i+1));
            }
        }
   String kati =ns.replaceAll("\\s+$", "");
   String ns = kati.trim().replaceAll(" +", " ");
  return ns;
}


    String fornumbers(int index,String n)
    {
        String num="";
     
        if(n.charAt(index) == '1')
        {
            num="one";
        }
        else if(n.charAt(index) =='2')
        {
            num ="two";
        }
        else if(n.charAt(index) =='3')
        {
            num ="three";
        }
        else if(n.charAt(index) =='4')
        {
            num ="four";
        }
        else if(n.charAt(index) =='5')
        {
            num ="five";
        }
        else if(n.charAt(index) =='6')
        {
            num ="six";
        }
        else if(n.charAt(index) =='7')
        {
            num ="seven";
        }
        else if(n.charAt(index) =='8')
        {
            num ="eight";
        }
        else if(n.charAt(index) =='9')
        {
            num ="nine";
        }
        return num;
    }


  String dekades(char arithmos,char monada)
  {
      String x="";
      String y="";
      if(arithmos=='1')
      {
          if(monada=='0')
          {
              x="ten";
              return x;
          }
          else if(monada =='1')
          {
              x="eleven";
              return x;
          }
          else if(monada =='2')
          {
              x="twelve";
              return x;
          }
          else if(monada =='3')
          {
              x="thirteen";
              return x;
          }
          else if(monada =='4')
          {
              x="fourteen";
              return x;
          }
          else if(monada =='5')
          {
              x="fifteen";
              return x;
          }
          
          else if(monada =='6')
          {
              x="sixteen";
              return x;
          }
          else if(monada =='7')
          {
              x="seventeen";
              return x;
          }
          else if(monada =='8')
          {
              x="eighteen";
              return x;
          }
          else if(monada =='9')
          {
              x="nineteen";
              return x;
          }
      }
      else if(arithmos=='2')
      {
          x="twenty";
      }
      else if(arithmos=='3')
      {
          x="thirty";
      }
      else if(arithmos =='4')
      {
          x="forty";
      }
      else if(arithmos =='5')
          {
              x="fifty";
          }
      else if(arithmos =='6')
          {
              x="sixty";
          }
      else if(arithmos =='7')
          {
              x="seventy";
          }
      else if(arithmos =='8')
          {
              x="eighty";
          }
      else if(arithmos =='9')
          {
              x="ninety";
          }
      if(monada=='0')
      {
          y="";
      }
      else if(monada=='1')
      {
          y="one";
      }
      else if(monada=='2')
      {
          y="two";
      }
      else if(monada=='3')
      {
          y="three";
      }
      else if(monada=='4')
      {
          y="four";
      }
      else if(monada=='5')
      {
          y="five";
      }
      else if(monada=='6')
      {
          y="six";
      }
      else if(monada=='7')
      {
          y="seven";
      }
      else if(monada=='8')
      {
          y="eight";
      }
      else if(monada=='9')
      {
          y="nine";
      }
      return x+ " "+y;
  }