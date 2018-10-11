package arcade.bookMarket;

import util.Chronometer;

/**
 * Created by JavierSainz on 11/6/16.
 */
public class HTMLEndTagByStartTag {
    String htmlEndTagByStartTag(String startTag) {
        StringBuilder endTag = new StringBuilder("</");
        for (int i = 1; i < startTag.length(); i++) {
            if (startTag.charAt(i) == ' ' || startTag.charAt(i) == '>') {
                break;
            }
            endTag.append(startTag.charAt(i));
        }
        endTag.append('>');
        return endTag.toString();
    }

    String htmlEndTagByStartTag2(String startTag) {
        return "</" + startTag.substring(1, startTag.lastIndexOf(' ') > -1 ?
                startTag.indexOf(' ') : startTag.lastIndexOf('>')) + ">";
    }

    public static void main(String[] args) {
        Chronometer c = Chronometer.start();
        System.out.println(new HTMLEndTagByStartTag().htmlEndTagByStartTag2("<div id='my_area' class='data' title='This is a test for title on Div tag'>"));
        //c.time();
        System.out.println(c.time());
    }
}
