package in.mkp.basic.level7;

/**
 * Created by mkumar on 3/6/17.
 */
public class StringRearrange {
    class Word {
        boolean selected;
        String word;

        Word(final String word) {
            this.word = word;
        }
    }

    public static void main(String args[]) {

        StringRearrange stringRearrange = new StringRearrange();
        //String[] str = {"abc","abd", "cdd"};
        String[] str = {"abc","xbc","xxc","xbc","aby","ayy","aby"};
        //String[] str = {"abc", "abc", "abx", "abx", "axx"};
        System.out.println(stringRearrange.stringsRearrangement(str));
    }

    boolean stringsRearrangement(String[] inputArray) {
        Word[] words = new Word[inputArray.length];
        int i=0;
        for (String s : inputArray) {
            words[i]=new Word(s);
            ++i;
        }
        arrange(-1, words, 0);
        return ret;
    }

    boolean ret = false;

    void arrange(int prev, Word[] words, int i) {
        if (i == words.length) {
            if (allSelected(words)) {
                ret = true;
            }
            return;
        }
        //words[i].selected = true;

        for (int j=0; j < words.length; ++j) {
            if (!words[j].selected && (prev == -1 || differByOne(words[prev].word, words[j].word))) {
                words[j].selected = true;
                arrange(j, words, j+1);
                words[j].selected = false;
            }
        }
        //words[i].selected = false;
    }



    boolean differByOne(String s1, String s2) {
        int len = s1.length();
        int diff = 0;
        for (int i = 0; i < len; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1 ? true : false;
    }

    boolean allSelected(Word[] words) {
        for (Word w : words) {
            if (!w.selected) {
                return false;
            }
        }
        return true;
    }


}
