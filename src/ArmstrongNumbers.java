
/**
 * An Armstrong number(or Narcissistic number) is a number that is the sum of its own digits
 * each raised to the power of the number of digits.
 * This method check,if given number is Armstrong number or not.
 */
class ArmstrongNumbers {

    ArmstrongNumbers(int numberToCheck) {

    }

    boolean isArmstrongNumber(int numberToCheck) {
        String stringNumber = Integer.toString(numberToCheck);
        String[] charNumberArray = stringNumber.split("");
        double temp;
        int sum = 0;
        for (String singleDigit : charNumberArray) {
            temp = Math.pow(Double.parseDouble(singleDigit), charNumberArray.length);
            sum += temp;
        }
        return numberToCheck == sum;
    }
}
