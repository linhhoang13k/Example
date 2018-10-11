package evg.codefights.core;

public class AtTheCrossroads {

    public static void main(String[] args) {
//        System.out.println(new AtTheCrossroads().reachNextLevel(10, 15, 5));
    }

    boolean reachNextLevel(int experience, int threshold, int reward) {
        return experience + reward >= threshold;
    }

    int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        if (weight1 + weight2 <= maxW) {
            return value1 + value2;
        } else if (value1 >= value2 && weight1 <= maxW) {
            return value1;
        } if (value2 >= value1 && weight2 <= maxW) {
            return value2;
        } else if (weight1 <= maxW) {
            return value1;
        }
        return 0;
    }

    int extraNumber(int a, int b, int c) {
        return a ^ b ^ c;
    }

    boolean isInfiniteProcess(int a, int b) {
        if (a > b) {
            return true;
        }
        if ((b - a) % 2 == 1) {
            return true;
        }
        return false;
    }

    boolean arithmeticExpression(int A, int B, int C) {
        if (A + B == C) {
            return true;
        } else if (A - B == C) {
            return true;
        } else if (A * B == C) {
            return true;
        } else if (A / B == C && A % B == 0) {
            return true;
        }
        return false;
    }

    boolean tennisSet(int score1, int score2) {
        if (score1 != score2) {
            if (Math.max(score1, score2) == 6 && Math.min(score1, score2) < 5) {
                return true;
            }
            if (Math.max(score1, score2) == 7 && Math.min(score1, score2) >= 5) {
                return true;
            }
        }
        return false;
    }

    boolean willYou(boolean young, boolean beautiful, boolean loved) {
        if (loved) {
            return !(young && beautiful);
        } else {
            return young && beautiful;
        }
    }

    int[] metroCard(int lastNumberOfDays) {
        if (lastNumberOfDays <= 30) {
            return new int[]{31};
        } else if (lastNumberOfDays == 31) {
            return new int[]{28, 30, 31};
        } else {
            return new int[0];
        }
    }
}
