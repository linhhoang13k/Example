package exercise38;

public class PlantGrowthTracker {
	/**
	 * 
	 * Each day a plant is growing by upSpeed meters. Each night that plant's height
	 * decreases by downSpeed meters due to the lack of sun heat. Initially, plant
	 * is 0 meters tall. We plant the seed at the beginning of a day. We want to
	 * know when the height of the plant will reach a certain level.
	 * 
	 * Example
	 * 
	 * For upSpeed = 100, downSpeed = 10 and desiredHeight = 910, the output should
	 * be growingPlant(upSpeed, downSpeed, desiredHeight) = 10.
	 */
	public int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
		int currentGrowth = 0;
		int currentDay = 0;
		while (currentGrowth < desiredHeight) {
			currentDay++;
			currentGrowth += upSpeed;
			if (currentGrowth >= desiredHeight) {
				return currentDay;
			}
			currentGrowth -= downSpeed;
		}
		return currentDay;
	}

	public int calculateTotalGrowth(int upSpeed, int downSpeed) {
		return upSpeed - downSpeed;
	}


}
