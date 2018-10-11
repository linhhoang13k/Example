/**
 * Created by seandunn92 on 4/24/17.
 */
import java.util.ArrayList;
public class Driver {


    private static int  currIndex = 0;
    static int wordLadder(String beginWord, String endWord, String[] wordList) {
        int numOfTrans =0;

       for(int i=0; i<wordList.length; i++){
           if(offByOneLetter(beginWord, wordList[i])){

               beginWord = wordList[i];
               numOfTrans++;

           }
       }
       if(beginWord.equals(endWord))
        return numOfTrans;
        return 0;
    }

    private static boolean offByOneLetter(String beginWord, String s) {
        int letterCount=0;

        for(int i=0; i<s.length(); i++){
            if (beginWord.charAt(i)!=s.charAt(i)){
                letterCount++;
            }
        }
        if (letterCount == 1)
            return true;

        return false;
    }
    public static void printArrayList(ArrayList<String> testArrayList){
        for (String s:testArrayList){
            System.out.println(s);
        }
    }


    public static void main(String[] args) {
        ArrayList<String> testArrayList = new ArrayList<String> ();
        testArrayList.add("Hello");
        testArrayList.add("Neighbor");
        printArrayList(testArrayList);
        testArrayList = new ArrayList<String>();
        printArrayList(testArrayList);



        int trans = wordLadder("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
   System.out.println("There were " + trans + " transformations");

        trans = wordLadder("a", "c", new String[] {"a", "b", "c"});
        System.out.println("There were " + trans + " transformations");
        trans = wordLadder("hot", "dog", new String[] {"hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"});
        System.out.println("There were " + trans + " transformations");


    }
}
