package torneo;
import java.util.*;
public class Reto1 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n;
		 int pos=0;
		int res=0;
		System.out.println("Input a number");
		 n = scan.nextInt();
		 
		 
		
			    
			    int[] numeros = new int[n];
			    
			   
			    for(int x=1;x<n;x++)
			        
			    {
			        
			        if(n%x==0  &&x!=1)
			            
			        {
			            
			            numeros[pos]=x  ;
			            pos++;
			           System.out.println(pos);
			        }      
			        
			       
			           
			        
			    }
			     
			    
			    
			  //  System.out.println(numeros[0]);
			    System.out.println(numeros[0]+""+numeros[pos-1]);
			    // String numero1 = numeros[0].toString();
			      //       String numero2 = numeros[numeros.lenght-1].toString();
			    
			    //String  nuevo=numero1+numero2;
			    
			    
			   // int result = Integer.parseInt(nuevo);
			    String regreso=numeros[0]+""+numeros[pos-1];
			    int result = Integer.parseInt(regreso);
			    
			    System.out.println(result);
			}

		 
	}

