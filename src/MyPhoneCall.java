/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Core Level 1
 * 
 * Some phone usage rate may be described as follows:
 * first minute of a call costs min1 cents,
 * each minute from the 2nd up to 10th (inclusive) costs min2_10 cents
 * each minute after 10th costs min11 cents.
 * You have s cents on your account before the call. 
 * 
 * What is the duration of the longest call (in minutes 
 * rounded down to the nearest integer) you can have?
 */
public class MyPhoneCall {
	
	// phoneCall method takes four ints which are cost of minutes
	// and returns int (the longest call).
	int phoneCall (int min1, int min2_10, int min11, int s) {
	    int phoneMinute = 0;
	    while (s>0) {
	    	phoneMinute++;
	        if(phoneMinute==1){
	        	if(s<min1){
	        		return 0;
	            } else if(s==min1){
	                return 1;
	            } else{
	                s-=min1;
	            }
	        } else if (phoneMinute>1 && phoneMinute <=10) {
	            s-=min2_10;
	            if(s==0){
	                break;
	            } else if(s<min2_10){
	                break;
	            }
	        } else {
	            s-=min11;
	            if(s==0){
	                 break;
	            } else if (s<min11) {
	                 break;
	            }
	        }
	    }
	    return phoneMinute;
	}
	
	// main method which tests phoneCall
	public static void main(String args[]){
		MyPhoneCall a = new MyPhoneCall();
		System.out.println(a.phoneCall(3,1,2,20));
	}
}
