package Arcade_Intro;

public class _38_growingPlant {
    int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int currentHeight = 0, daysElapsed = 1;
        while(currentHeight < desiredHeight){
            currentHeight += upSpeed; // grow by day
            if(currentHeight >= desiredHeight) return daysElapsed;
            else{
                daysElapsed++; // day passed
                currentHeight -= downSpeed; // shrink during night
            }
        }
        return -1;
    }

    int growingPlantOneLiner(int upSpeed, int downSpeed, int desiredHeight) {
        // Height after x days in the middle of the day (only grew): (upSpeed-downSpeed) * (x - 1) + upSpeed
        // Return x if [desiredHeight <= (upSpeed-downSpeed) * (x - 1) + upSpeed]
        // Return smallest possible x where [(desiredHeight - upSpeed) / (upSpeed-downSpeed) + 1 <= x]
        return Math.max(0, (int)Math.ceil((double) (desiredHeight - upSpeed) / (upSpeed - downSpeed))) + 1;
        // Math.max since desiredHeight - upSpeed can be negative, if we reach the height in first day.
    }



}
