import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StringUtilitiesTest {

    @Test
    public void testLongestSubstring_NoSubstring(){
        assertThat(StringUtilities.longestSubstring("aaa", 2), is(0));
    }

    @Test
    public void testLongestSubstring_SingleDistinctCharacterWholeString(){
        assertThat(StringUtilities.longestSubstring("aaa", 1), is(3));
    }

    @Test
    public void testLongestSubstring_SubstringEndOfString(){
        assertThat(StringUtilities.longestSubstring("abcc", 2), is(3));
    }

    @Test
    public void testLongestSubstring_SingleDistinctCharacter(){
        assertThat(StringUtilities.longestSubstring("abcccc", 1), is(4));
    }

    @Test
    public void testLongestSubstring_SubstringIsEntireString(){
        assertThat(StringUtilities.longestSubstring("aaaaaabc", 3), is(8));
    }
}