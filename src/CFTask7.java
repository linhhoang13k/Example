package CodeFightsTasks;

/**
 * Created by Pasha on 22.01.2018.
 */
public class CFTask7 {
    private static boolean almostIncreasingSequence(int[] sequence) {
        boolean strictlySequence = false;
        boolean sq = false;
        boolean flag = true;
        boolean flagEnd = true;
        if (sequence.length > 100000)
            return false;
        for (int i = 0; i < sequence.length; i++) {
            int blockElement = sequence.length - i - 1;
            for (int j = 0; j < sequence.length - 1; j++) {
                if ( flag) {
                    if ((i == sequence.length - 1) && (j + 1 == i)){
                        strictlySequence = true;
                        flag = false;
                    }
                    else if ((j + 1 != i) && (i != j) && (sequence[j] < sequence[j + 1]))
                        strictlySequence = true;
                    else if ((i != j) && (j + 1 == i) && (j + 2 < sequence.length) && (sequence[j] < sequence[j + 2]))
                        strictlySequence = true;
                    else if (i == j) {}
                    else {
                        strictlySequence = false;
                        flag = false;

                    }
                }
                if (flagEnd) {
                    if ((blockElement == sequence.length - 1) && (j + 1 == blockElement)){
                        sq = true;
                        flagEnd = false;
                    }
                    else if ((j + 1 != blockElement) && (blockElement != j) && (sequence[j] < sequence[j + 1]))
                        sq = true;
                    else if ((blockElement != j) && (j + 1 == blockElement) && (j + 2 < sequence.length) && (sequence[j] < sequence[j + 2]))
                        sq = true;
                    else if (blockElement == j) {}

                    else {
                        sq = false;
                        flagEnd = false;
                    }
                }
            }
            System.out.println(strictlySequence + ":" + sq);
            if (strictlySequence || sq)
                break;
            flag = true;
            flagEnd = true;
        }
        System.out.println(sequence.length);
        return sq || strictlySequence;
    }
}
