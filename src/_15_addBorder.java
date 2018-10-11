package Arcade_Intro;

public class _15_addBorder {
    String[] addBorder(String[] picture) {
        String[] result = new String[picture.length + 2];

        result[0] = "";
        for (int i = 0; i < picture[0].length() + 2; i++)
            result[0] += "*";

        result[result.length-1] = "";
        // Footer
        for (int i = 0; i < picture[0].length() + 2; i++)
            result[result.length - 1] += "*";

        // Body
        for(int i = 0; i < picture.length; i++){
            result[i+1] = "";
            result[i+1] = "*" + picture[i] + "*";
        }
        return result;
    }
}
