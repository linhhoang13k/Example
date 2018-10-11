/*Given the string, check if is a palindrome
[input] string inputString , a non-empty string consosting of lowercase letters
[output] boolen , true if inputString is palindrome, false otherwise
*/



boolean checkPalindrome(String inputString) {
    String reversedString = new StringBuilder(inputString).reverse().toString();
    boolean isPalindrome = inputString.matches(reversedString);
    return isPalindrome;
}
