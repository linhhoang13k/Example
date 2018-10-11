package CodeFight;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest  {
    Graph graph = new Graph();
    @Test
    public void countPath() {
        /*
         * 0 0 0 0 0
         * 0 1 0 0 0
         * 0 1 0 0 0
         * 0 1 0 1 0
         * 0 0 0 1 0
         * 1 - blocker
         * */
        int[][] matrix = {{0,0,0,0,0}
                         ,{0,1,0,0,0}
                         ,{0,1,0,0,0}
                         ,{0,1,0,1,0}
                         ,{0,0,0,1,0}};
        int[] start = {0,0};
        int[] dest = {4,4};
        int expected = 7;
        int actual = graph.countPath(start,dest,matrix,"");
        Assert.assertEquals(expected,actual);
    }
}