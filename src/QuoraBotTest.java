package CodeFight;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 3/12/18.
 */
public class QuoraBotTest {
    QuoraBot bot = new QuoraBot();
    @Test
    public void mostViewedWriters() throws Exception {

        int[][] topicIds= {{1,2,3}, {2,3,4}, {1,4}, {2,3}};
        int[][] answerIds= {{6,4}, {1,2}, {5}, {3}};
        int[][] views= {{2,1,2}, {6,3,5}, {3,3,0}, {5,1,1}, {4,2,3}, {1,4,2}};
        int[][][] res = {{{3,5},{2,3},{1,1}},
                {{3,5},{2,3},{1,2},{4,2}},
                {{3,5},{2,3},{1,2},{4,2}},
                {{1,3},{4,2}}};
        int[][][] actual = bot.mostViewedWriters(topicIds,answerIds,views);
        assertArrayEquals(res,actual);
    }

    @Test
    public void relatedQuestions() throws Exception {
        int n = 5;
        int[] t;// = {2, 2, 1, 2, 2};
        int[][] edges;// = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int expected=0,actual=0;
//        int expected = 2;
//        int actual = bot.relatedQuestions(n, t, edges);
//        assertEquals(expected, actual);

        n = 5;
        t = new int[]{3, 11, 3, 18, 3};
        edges = new int[][]{{3, 1}, {4, 2}, {0, 3}, {4, 1}};
        expected = 4;
        actual = bot.relatedQuestions(n, t, edges);
        assertEquals(expected, actual);

        n = 5;
        t = new int[]{2, 1, 13, 1, 12};
        edges = new int[][]{{3, 0}, {3, 2}, {4, 1}, {3, 1}};
        expected = 3;
        actual = bot.relatedQuestions(n, t, edges);
        assertEquals(expected, actual);
    }
}