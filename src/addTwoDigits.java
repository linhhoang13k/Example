/*
*	Challenge Name: Add Two Digits
*	Input is two digits, add the sum of both integers
*/

int addTwoDigits(int n) {
    int result = 0;
    try {
        
        if (10 <= n && n <= 99) {
            String numString = Integer.toString(n);

            char firstNum = numString.charAt(0);
            char secondNum = numString.charAt(1);

            int firstInt = Character.getNumericValue(firstNum);
            int secondInt = Character.getNumericValue(secondNum);

            result = firstInt + secondInt;
            return result;
        } else {
            System.out.println("The value you entered was no two digits.");
            return result;
        }
    } catch (Exception e) {
        System.out.println("Error: " + e);
        return result;
    }
}
