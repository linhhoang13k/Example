public class PalindromeReagranging {

    boolean palindromeRearranging(String inputString) {
        if (inputString.length() < 2)
            return true;

        int[] ledger = new int[26];

        for (int i = 0; i < inputString.length(); i++) {
            int index = Character.getNumericValue(inputString.charAt(i)) - 10;
            if (ledger[index] == 0)
                ledger[index]++;
            else
                ledger[index]--;
        }

        int counter = 0;

        for (int aLedger : ledger) {
            if (aLedger == 1)
                counter++;
        }

        return counter == 1 && inputString.length() % 2 != 0 || !(counter > 1);
    }

}
