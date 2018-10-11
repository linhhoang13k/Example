package test;
/*
 * Each day a plant is growing by upSpeed meters. 
 * Each night that plant's height decreases by downSpeed meters due to the lack of sun heat. Initially, plant is 0 meters tall. We plant the seed at the beginning of a day. We want to know when the height of the plant will reach a certain level.

Example

For upSpeed = 100, downSpeed = 10 and desiredHeight = 910, the output should be
growingPlant(upSpeed, downSpeed, desiredHeight) = 10.

Input/Output

[time limit] 3000ms (java)
[input] integer upSpeed

A positive integer representing the daily growth.

Guaranteed constraints:
5 ≤ upSpeed ≤ 100.

[input] integer downSpeed

A positive integer representing the nightly decline.

Guaranteed constraints:
2 ≤ downSpeed < upSpeed.

[input] integer desiredHeight

A positive integer representing the threshold.

Guaranteed constraints:
4 ≤ desiredHeight ≤ 1000.

[output] integer

The number of days that it will take for the plant to reach/pass desiredHeight (including the last day in the total count).


 */

public class GrowingPlant {
	
	int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
		
		 if (desiredHeight <= upSpeed) return 1;
			
		 int days = Math.abs(desiredHeight / (upSpeed - downSpeed));
				
				int growth = days* (upSpeed - downSpeed);
				
				while (desiredHeight <= growth)
				{
					growth = growth + upSpeed;
					if (growth >= desiredHeight){ days++; return days;}
					else {growth = growth - downSpeed;
					days++;
					}
				}
				return days;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrowingPlant obj = new GrowingPlant();
		System.out.println(obj.growingPlant(10, 3, 8));

	}

}
