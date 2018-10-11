package arcade.nestedLoops;

/**
 * Created by JavierSainz on 11/5/16.
 */
public class CrosswordFormation {
    int crosswordFormation(String[] words) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int l = 6 - j - i - k;
                    String verticalWord1 = words[i];
                    String verticalWord2 = words[j];
                    String horizontalWord1 = words[k];
                    String horizontalWord2 = words[l];

                    for (int charIndexV = 0; charIndexV < verticalWord1.length(); charIndexV++) {
                        for (int charIndexH = 0; charIndexH < horizontalWord1.length() - 2; charIndexH++) {
                            if (verticalWord1.charAt(charIndexV) == horizontalWord1.charAt(charIndexH)) {
                                for (int charIndexHContinue = charIndexH + 2; charIndexHContinue < horizontalWord1.length(); charIndexHContinue++) {
                                    for (int charIndexV2 = 0; charIndexV2 < verticalWord2.length() - 2; charIndexV2++) {
                                        if (verticalWord2.charAt(charIndexV2) == horizontalWord1.charAt(charIndexHContinue)) {
                                            int verticalWordPositionDifference = charIndexV2 - charIndexV;
                                            int rectangleWidth = charIndexHContinue - charIndexH;
                                            outer:
                                            for (int charIndexVContinue = charIndexV + 2; charIndexVContinue < verticalWord1.length(); charIndexVContinue++) {
                                                for (int charIndexH2 = 0; charIndexH2 < horizontalWord2.length() - rectangleWidth; charIndexH2++) {
                                                    //validate vertical word 2 position
                                                    if (charIndexVContinue + verticalWordPositionDifference >= verticalWord2.length()) {
                                                        break outer;
                                                    }
                                                    if (horizontalWord2.charAt(charIndexH2) == verticalWord1.charAt(charIndexVContinue) &&
                                                            horizontalWord2.charAt(charIndexH2 + rectangleWidth) ==
                                                                    verticalWord2.charAt(charIndexVContinue + verticalWordPositionDifference)) {
                                                        count++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }


            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CrosswordFormation().crosswordFormation(new String[]{
                "phenomenon",
                "remuneration",
                "particularly",
                "pronunciation"
        }));

    }


}