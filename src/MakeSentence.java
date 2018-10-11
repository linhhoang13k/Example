public class MakeSentence {

    String makeSentence(char[][] words) {
        StringBuilder s = new StringBuilder();
        for(char[] a : words){
            for(char ch : a){
                s.append(ch);
            }
            s.append(' ');
        }
        
        return s.substring(0, s.length() - 1) + '.';
    }

}
