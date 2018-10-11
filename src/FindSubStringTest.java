package interviewpractice.trees;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class FindSubStringTest {

    private FindSubString find = new FindSubString();

    private String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
    private String[] parts = {"a", "mel", "lon", "el", "An"};
    private String[] testOneResult = {"Apple", "Me[lon]", "Or[a]nge", "Water[mel]on"};
    private String[] words2 = {"Aaaaaaaaa", "bcdEFGh"};
    private String[] parts2 = {"aaaaa", "Aaaa", "E", "z", "Zzzzz"};
    private String[] testTwoResult = {"A[aaaaa]aaa", "bcd[E]FGh"};
    private String[] words3 = {"abc"};
    private String[] parts3 = {"abc"};
    private String[] testThreeResult = {"[abc]"};
    private String[] words4 = {"Aaaaaaaaa", "bcdEFGh", "Apple", "Melon", "Orange", "Watermelon"};
    private String[] parts4 = {};
    private String[] testFourResult = {"Aaaaaaaaa", "bcdEFGh", "Apple", "Melon", "Orange", "Watermelon"};

    @Test
    public void testFindSubstrings() {
        String[] result = find.findSubstrings(words, parts);
        assertArrayEquals(testOneResult, result);
    }

    @Test
    public void testFindSubstringsTwo() {
        String[] result = find.findSubstrings(words2, parts2);
        assertArrayEquals(testTwoResult, result);
    }

    @Test
    public void testFindSubstringsThree() {
        String[] result = find.findSubstrings(words3, parts3);
        assertArrayEquals(testThreeResult, result);
    }

    @Test
    public void testFindSubstringsFour() {
        String[] result = find.findSubstrings(words4, parts4);
        assertArrayEquals(testFourResult, result);
    }
}