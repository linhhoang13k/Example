package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _42_bishopAndPawnTest {
    static final _42_bishopAndPawn obj = new _42_bishopAndPawn();

    @Test
    void bishopAndPawn() {
        assertEquals(obj.bishopAndPawn("a1", "c3"), true);
        assertEquals(obj.bishopAndPawn("h1", "h3"), false);
        assertEquals(obj.bishopAndPawn("a5", "c3"), true);
        assertEquals(obj.bishopAndPawn("g1", "f3"), false);
        assertEquals(obj.bishopAndPawn("e7", "d6"), true);
        assertEquals(obj.bishopAndPawn("e7", "a3"), true);
        assertEquals(obj.bishopAndPawn("e3", "a7"), true);
        assertEquals(obj.bishopAndPawn("a1", "h8"), true);
        assertEquals(obj.bishopAndPawn("a1", "h7"), false);
        assertEquals(obj.bishopAndPawn("h1", "a8"), true);
    }
}
