package interviewpractice.heapsStacksQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class SimplifyPathTest {

    private SimplifyPath simple = new SimplifyPath();

    private String testString = "/home/a/./x/../b//c/";
    private String testString2 = "/a/b/c/../..";
    private String testString3 = "/../";
    private String testString4 = "/home//foo/";
    private String testString5 = "/AagbK/////iavh/M/rmKaS/tXD/././lND//";
    private String testString6 = "/N/cKX/bdrC/./ozFyd/NyuwO/";

    @Test
    public void testSimplifyPathOne() {
        String result = simple.simplifyPath(testString);
        assertEquals("/home/a/b/c",result);
    }

    @Test
    public void testSimplifyPathTwo() {
        String result = simple.simplifyPath(testString2);
        assertEquals("/a",result);
    }

    @Test
    public void testSimplifyPathThree() {
        String result = simple.simplifyPath(testString3);
        assertEquals("/",result);
    }

    @Test
    public void testSimplifyPathFour() {
        String result = simple.simplifyPath(testString4);
        assertEquals("/home/foo",result);
    }

    @Test
    public void testSimplifyPathFive() {
        String result = simple.simplifyPath(testString5);
        assertEquals("/AagbK/iavh/M/rmKaS/tXD/lND",result);
    }

    @Test
    public void testSimplifyPathSix() {
        String result = simple.simplifyPath(testString6);
        assertEquals("/N/cKX/bdrC/ozFyd/NyuwO",result);
    }
}