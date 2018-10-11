/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 5
 * 
 * An IP address is a numerical label assigned 
 * to each device (e.g., computer, printer) 
 * participating in a computer network that uses
 * the Internet Protocol for communication. 
 * There are two versions of the Internet protocol, 
 * and thus two versions of addresses. One of them 
 * is the IPv4 address.
 * 
 * IPv4 addresses are represented in dot-decimal 
 * notation, which consists of four decimal numbers, 
 * each ranging from 0 to 255, separated by dots,
 * e.g., 172.16.254.1.
 *  
 * Given a string, find out if it satisfies the 
 * IPv4 address naming rules.
 */

public class MyIsIPv4Address {
	
	// isIPv4Address function takes in a string 
	// as an input parameter and returns and boolean
	boolean isIPv4Address(String inputString) {

	    boolean isAddress = false;
	    String[] input = inputString.trim().split("\\.");
	    
	    for (int i =0; i<input.length; i++) {
	        if ((input[i].length()!=0 && input.length<=4)) {
	            try{
	                if (Integer.valueOf(input[i])>=0 && Integer.valueOf(input[i])<=255 ) {
	                    isAddress=true;
	                } else {
	                    isAddress = false;
	                    break;
	                }
	            }
	            catch (NumberFormatException e) {
	            	isAddress = false;
	                break;
	            }
	        } else {
	            isAddress = false;
	            break;
	        }
	    }
	    return isAddress;
	}
	
	// main tests isIPv4Address function
	public static void main(String args[]){
		MyIsIPv4Address a = new MyIsIPv4Address();
		System.out.println((a.isIPv4Address("172.16.254.1")));
	}
}
