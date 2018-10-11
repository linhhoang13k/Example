
/**
 * Description:
 * Imagine that you have clock with only one clock hand. In this algorithm takes single number represented angle between
 * clock hand and number 12 at the clock face. The output is current time in format "hh:mm".
 */
class WhatTimeIsIt {

    WhatTimeIsIt(final double angle) {

    }

    String currentTime(final double angle) {
        if (angle < 0 || angle > 360) {
            return "Incorrect value";
        }
        int wholeMinute = (int) (angle + angle);
        int hourInt = 0;
        while (wholeMinute >= 60) {
            hourInt++;
            wholeMinute = wholeMinute - 60;
        }
        String hour = hourInt < 10 ? "0" + Integer.toString(hourInt) : Integer.toString(hourInt);
        if (hourInt == 0) hour = "12";
        int minuteInt = 0;
        while (wholeMinute > 0) {
            minuteInt++;
            wholeMinute--;
        }
        String minute = minuteInt < 10.0 ? "0" + Integer.toString(minuteInt) : Integer.toString(minuteInt);
        return String.format("%s:%s", hour, minute);
    }
}
