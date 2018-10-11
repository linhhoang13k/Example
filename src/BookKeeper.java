package in.mkp.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mkumar on 3/25/17.
 */
public class BookKeeper {

    public static void main(String[] args) {
        BookKeeper bookKeeper = new BookKeeper();
        String[][] books = new String[][] {{"Of Mice and Men", "The Hunger Games", "The Grapes of Wrath"},
                {"Black Beauty", "The Book Thief"},
                {"Harry Potter and the Sorcerer's Stone","Divergent","Java For Dummies"}};
        System.out.println(Arrays.toString(bookKeeper.BookKeeper(books)));
    }

    String[][] BookKeeper(String[][] books) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int maxCol = -1;
        for (int i=0; i < books.length; ++i) {
            maxCol = Math.max(books[i].length, maxCol);
            for (int j=0; j < books[i].length; ++j) {
                String r = replace(books[i][j]).trim();
                list.add(r);
                map.put(r, books[i][j]);
            }
        }
        Collections.sort(list);

        String[][] ret = new String[books.length][];
        for (int i=0; i < books.length; ++i) {
            ret[i] = new String[books[i].length];
        }

        int k=0;
        for (int j=0; j < maxCol; ++j) {
            for (int i=0; i < books.length; ++i) {
                try {
                    ret[i][j] = map.get(list.get(k));
                    k++;
                }
                catch (IndexOutOfBoundsException e) {
                }
            }
        }
        return ret;
    }

    String replace(String str) {
        return  str.toLowerCase().replaceAll("\\ba\\b", " ")
                .replaceAll("\\bthe\\b", " ")
                .replaceAll("\\bof\\b", " ")
                .replaceAll("\\band\\b", " ")
                .replaceAll("  ", " ");
    }
}
