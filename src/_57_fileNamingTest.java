package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _57_fileNamingTest {
    _57_fileNaming obj = new _57_fileNaming();

    @Test
    void fileNaming() {
        assertArrayEquals(obj.fileNaming(new String[] {"doc", "doc", "image", "doc(1)", "doc"}),
                                    new String[]{"doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"});
        assertArrayEquals(obj.fileNaming(new String[] {"a(1)", "a(6)", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"}),
                                    new String[]{"a(1)", "a(6)", "a", "a(2)", "a(3)", "a(4)", "a(5)", "a(7)", "a(8)", "a(9)", "a(10)", "a(11)"});
        assertArrayEquals(obj.fileNaming(new String[] {"dd", "dd(1)", "dd(2)", "dd", "dd(1)", "dd(1)(2)", "dd(1)(1)", "dd", "dd(1)"}),
                                    new String[]{"dd", "dd(1)", "dd(2)", "dd(3)", "dd(1)(1)", "dd(1)(2)", "dd(1)(1)(1)", "dd(4)", "dd(1)(3)"});
    }

}