package com.codefight.williamking.dailychallenges.dicerolls;

public class DiceRolls {

	public static int diceRolls(int[][] dice, int sum) {

	    double tally = 0;
	    double total = 0;
	    boolean finished = false;
	    
	    System.out.println("dice length: " + dice.length);
	    if (dice.length == 0) {
	        return 0;
	    }
	    
	    int[] location = new int[dice.length];
	    
	    for (int k = 0; k < dice.length; k++) {
	        location[k] = 0;
	    }
	    
	    while(!finished) {
	        for (int j = 0; j < dice.length && total <= sum; j++) { 
	            System.out.print("(" +  j + "," + location[j] + "):" + dice[j][location[j]] + " :: ");
	            total += dice[j][location[j]];
	        }
	        
	        System.out.print("Total: " + total + "::");
	        if (total == (double)sum) {
	            tally++;
	            System.out.print("New Tally: " + tally);
	        }
	        
	        for (int m = 0; m < location.length; m++) {
	            //System.out.print("Location before: " + location[m] + " ");
	            location[m]++;
	            //System.out.print("Location after: " + location[m] + " ");
	        
	            if (location[m] >= dice[m].length) {
	                location[m] = 0;
	                
	                if (m + 1 == dice.length) {
	                    finished = true;
	                }
	            } else {
	                break;
	            }
	        }
	        
	        total = 0;
	        System.out.println(" -- ");
	        
	    } 
	    
	    return (int)tally;
	    //return (int)(tally % (10 ^ 9 + 7) );
	}

}
