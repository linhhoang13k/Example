package CodeWars;

import java.util.ArrayList;
import java.util.List;

public class CardGame {

    //Steve is dealt: ['A','7','8']
    //Josh is dealt:  ['K','5','9']
    //return:       "Steve wins 2 to 1"

    public static void main(String[] args) {

//        String[] deckSteve = new String[]{"3", "7", "8"};
//        String[] deckJosh = new String[]{"4", "5", "9"};

        String[] deckSteve = new String[]{"A", "T", "8"};
        String[] deckJosh = new String[]{"4", "5", "9"};

        System.out.println(winner(valueConverter(deckSteve),valueConverter(deckJosh)));
    }

    //compare decks and declare winner
    private static String winner(int[] deckSteve, int[] deckJosh){

        int steveScore = 0;
        int joshScore = 0;

        for (int i = 0; i < deckSteve.length; i++) {
            if(deckSteve[i] > deckJosh[i]) {
                steveScore++;
            } else if (deckSteve[i] < deckJosh[i]) {
                joshScore++;
            }
        }
        if(steveScore > joshScore) {
            return "Steve wins " + steveScore + " to " + joshScore;
        } else if (steveScore < joshScore) {
            return "Josh wins " + joshScore + " to " + steveScore;
        } else //if steveScore == joshScore
            return "Tie";
    }

    //convert all letter cards to numeric values
    //'2','3','4','5','6','7','8','9',' T',' J',' Q',' K',' A'
    //'2','3','4','5','6','7','8','9','10','11','12','13','14'
    private static int[] valueConverter(String[] origDeck){
        List<Integer> deck = new ArrayList<>();
        for(String card: origDeck)
            switch(card) {
                case "T": deck.add(10); break;
                case "J": deck.add(11); break;
                case "Q": deck.add(12); break;
                case "K": deck.add(13); break;
                case "A": deck.add(14); break;
                default: deck.add(Integer.parseInt(card));
            }
        int[] intArray = new int[deck.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = deck.get(i);
        }
        return intArray;
    }
}