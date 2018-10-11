package arcade.islandofknowledge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AreEquallyStrongTest {

    @Test
    public void BothArmsCombosAreSame() {
        assertTrue(areEquallyStrong(10, 15, 10, 15));
    }

    @Test
    public void ArmsAreSwitched() {
        assertTrue(areEquallyStrong(10, 15, 15, 10));
    }

    @Test
    public void StrongArmsMatch_WeakArmsDoNot() {
        assertFalse(areEquallyStrong(15, 10, 15, 9));
    }

    @Test
    public void TotalsAreSameButArmsAreMismatched() {
        assertFalse(areEquallyStrong(10, 15, 5, 20));
    }


    boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        return (Math.min(yourLeft, yourRight) == Math.min(friendsLeft, friendsRight) &&
                (Math.max(yourLeft, yourRight) == Math.max(friendsLeft, friendsRight)));
    }
}
