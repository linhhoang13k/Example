/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Core Level 1
 * 
 * You are playing an RPG game. Currently 
 * your experience points (XP) total is equal 
 * to experience. To reach the next level your 
 * XP should be at least at threshold. If you 
 * kill the monster in front of you, you will 
 * gain more experience points in the amount of the reward.
 * 
 * Given values experience, threshold and reward, 
 * check if you reach the next level after killing the monster.
 */
public class MyReachNextLevel {
	
	// reachNextLevel method takes in three ints (experience, threshold, reward)
	// and returns true/false depending if we've reached next level
	boolean reachNextLevel(int experience, int threshold, int reward) {
	    boolean level = false; 
	    if ((experience+reward)>=threshold) {
	        level = true;
	    }
	    return level;
	}
	
	// main tests reachNextLevel method
	public static void main(String args[]){
		MyReachNextLevel a = new MyReachNextLevel();
		System.out.println(a.reachNextLevel(10,15,5));
	}
}
