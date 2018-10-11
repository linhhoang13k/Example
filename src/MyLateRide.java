/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 5
 * 
 * One night you go for a ride on your 
 * motorcycle. At 00:00 you start your 
 * engine, and the built-in timer automatically 
 * begins counting the length of your ride, 
 * in minutes. Off you go to explore the neighborhood.
 * 
 * When you finally decide to head back, you realize 
 * there's a chance the bridges on your route home are 
 * up, leaving you stranded! Unfortunately, you don't 
 * have your watch on you and don't know what time it is. 
 * All you know thanks to the bike's timer is that n minutes 
 * have passed since 00:00.
 * 
 * Using the bike's timer, calculate the current time. 
 * Return an answer as the sum of digits that the digital 
 * timer in the format hh:mm would show.
 * 
 */
import java.util.LinkedList;

public class MyLateRide {
	
	// lateRide function takes in a string 
	// as an input parameter and returns and boolean
	int lateRide(int n) {
	    int lateRide = 0;
	    int hour = n/60;
	    int minute = n%60;
	    LinkedList<Integer> stack = new LinkedList<Integer>();
	    while (hour > 0 || minute > 0) {
	        stack.push( hour % 10 );
	        stack.push(minute%10);
	        hour = hour / 10;
	        minute = minute / 10;
	    }

	    while (!stack.isEmpty()) {
	        lateRide += stack.pop();
	    }
	    return lateRide;
	}
	
	// main tests lateRide function
	public static void main(String args[]){
		MyLateRide a = new MyLateRide();
		System.out.println(a.lateRide(240));
	}
}
