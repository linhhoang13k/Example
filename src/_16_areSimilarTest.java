package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _16_areSimilarTest {
    final static _16_areSimilar obj = new _16_areSimilar();
    @Test
    void areSimilar() {
        assertEquals(obj.areSimilar(new int[] {1, 2, 3}, new int[]{1, 2, 3}), true);
        assertEquals(obj.areSimilar(new int[] {1, 2, 3}, new int[]{2, 1, 3}), true);
        assertEquals(obj.areSimilar(new int[] {1, 2, 2}, new int[]{2, 1, 1}), false);
    }

}