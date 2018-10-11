package HackerRank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Noosh on 03/07/17.
 */
public class Tries_Contacts {

    Node root;

    Tries_Contacts() {
        root = new Node();
    }

    class Node {
        HashMap<Character, Node> children;      // stores all children of this node
        boolean isCompleteWord;
        int completeWordsFromHere;

        // root node constructor
        Node() {
            this.isCompleteWord = false;
            this.completeWordsFromHere = 0;
            children = new HashMap<>();
        }

        Node(boolean completeWord, String wordToAdd) {
            System.out.println("making new node");
            this.isCompleteWord = completeWord;
            children = new HashMap<>();

            // might need to generate nodes multiple layers deeper
            if (wordToAdd.length() > 0) {
                this.completeWordsFromHere = 0;
                addWord(wordToAdd);
            } else {
                this.completeWordsFromHere = 1;
            }

        }

        // method to build a new word into the try
        void addWord(String word) {

            System.out.println("In addWord");

            // if no further letters left, have completed a word so this node must represent a valid word
            if (word.length() == 0) {
                this.isCompleteWord = true;
                // otherwise, more letters to get through
            } else if (children.containsKey(word.charAt(0))) {
                Node nextLetter = children.get(word.charAt(0));
                // move along one and pass in the substring
                nextLetter.addWord(word.substring(1));
            } else {
                children.put(word.charAt(0), new Node(false, word.substring(1)));
            }
            this.completeWordsFromHere += 1;
            System.out.println(completeWordsFromHere);
        }

        void findPrefix(String word) {

            // no further letters, can now count how many words this is a prefix for
            if (word.length() == 0) {
                System.out.println(countWords());
                // further letters in the prefix. Make sure exists by recursing down children
            } else if (children.containsKey(word.charAt(0))) {
                children.get(word.charAt(0)).findPrefix(word.substring(1));
            } else
                System.out.println(0);
            // if next letter doesn't exist, nothing contains that prefix so let the stack empty
        }

        int countWords() {
            return completeWordsFromHere;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Tries_Contacts tries = new Tries_Contacts();

        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if (op.equals("add"))
                tries.root.addWord(contact);
            else if (op.equals("find"))
                tries.root.findPrefix(contact);
        }
    }
}
