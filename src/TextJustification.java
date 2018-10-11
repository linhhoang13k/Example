package interviewpractice.strings;

import java.util.ArrayList;

/**
 * @author benmakusha
 */
public class TextJustification {

    String[] textJustification(String[] words, int l) {
        ArrayList<String> result = new ArrayList<>();

        if(words==null || words.length==0){
            return new String[0];
        }

        int count=0;
        int last=0;
        for(int i=0; i<words.length; i++){
            count = count + words[i].length();

            if(count+i-last>l){
                int wordsLen = count-words[i].length();
                int spaceLen = l-wordsLen;
                int eachLen = 1;
                int extraLen = 0;

                if(i-last-1>0){
                    eachLen = spaceLen/(i-last-1);
                    extraLen = spaceLen%(i-last-1);
                }

                StringBuilder sb = new StringBuilder();

                for(int k=last; k<i-1; k++){
                    sb.append(words[k]);

                    int ce = 0;
                    while(ce<eachLen){
                        sb.append(" ");
                        ce++;
                    }

                    if(extraLen>0){
                        sb.append(" ");
                        extraLen--;
                    }
                }

                sb.append(words[i-1]); //last words in the line
                //if only one word in this line, need to fill left with space
                while(sb.length()<l){
                    sb.append(" ");
                }

                result.add(sb.toString());

                last = i;
                count=words[i].length();
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=last; i<words.length-1; i++){
            count = count+words[i].length();
            sb.append(words[i]+" ");
        }

        sb.append(words[words.length-1]);
        while(sb.length()<l){
            sb.append(" ");
        }
        result.add(sb.toString());

        String[] actualResult = new String[result.size()];
        actualResult = result.toArray(actualResult);

        return actualResult;
    }

}
