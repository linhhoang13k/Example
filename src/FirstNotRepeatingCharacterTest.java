import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstNotRepeatingCharacterTest {

    @Test
    public void testCharacterCDuplicate() {
        char expectedOutput = 'c';

        String testInput = "abacabad";

        char actualFirstDuplicate = FirstNotRepeatingCharacter.firstNotRepeatingCharacter(testInput);
        System.out.println("actualFirstDuplicate = " + actualFirstDuplicate);
        System.out.println("expectedOutput = " + expectedOutput);
        assertEquals(expectedOutput, actualFirstDuplicate);
    }

}
