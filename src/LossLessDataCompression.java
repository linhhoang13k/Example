import java.util.*;

public class losslessDataCompression {
    String losslessDataCompression(String inputString, int width) {
        String result = "";
        for (int i = 0; i < inputString.length(); i++) {
            String window = "";
            int g = 0;
            try {
                window = inputString.substring(i - width, i);
                g = i - width;
            }
            catch (Exception e) {
                window = inputString.substring(0, i);
                g = 0;
            }
            if (!window.contains("" + inputString.charAt(i))) {
                result += inputString.charAt(i);
            }
            else {
                ArrayList<ArrayList<Integer>> index = new ArrayList<>();
                for (int startIndex = g; startIndex < inputString.length(); startIndex++) {
                    for (int length = 1; length < inputString.length(); length++) {
                        try {
                            if (inputString.substring(i, i + length).equals(inputString.substring(startIndex,
                                    startIndex + length)) &&
                                    window.contains(inputString.substring(startIndex, startIndex + length))
                                    && window.contains("" + inputString.charAt(i))
                            ) {
                                index.add(new ArrayList<>(Arrays.asList(startIndex, length)));
                            }
                        } catch (Exception e) {}
                    }
                }
                int max = index.get(0).get(1);
                for (int a = 1; a < index.size(); a++) {
                    if (index.get(a).get(1) > max) {
                        max = index.get(a).get(1);
                    }
                }
                final int predicate = max;
                index.removeIf(x -> x.get(1) != predicate);
                int min = index.get(0).get(0);
                for (int a = 1; a < index.size(); a++) {
                    if (index.get(a).get(0) < min) {
                        min = index.get(a).get(0);
                    }
                }
                final int predicate2 = min;
                index.removeIf(x -> x.get(0) != predicate2);
                result += "(" + index.get(0).get(0) + "," + index.get(0).get(1) + ")";
                i += index.get(0).get(1) - 1;
            }
        }
        return result;
    }
}
