package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _44_findEmailDomainTest {
    static final _44_findEmailDomain obj = new _44_findEmailDomain();

    @Test
    void findEmailDomain() {
        assertEquals(obj.findEmailDomain("prettyandsimple@example.com"), "example.com");
        assertEquals(obj.findEmailDomain( "someaddress@yandex.ru"), "yandex.ru");
    }

}