package CodeFight;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {
    LRUCache cache = new LRUCache(3);

    @Test
    public  void testOperation(){
        cache.set(2,4);
        cache.set(3,6);
        cache.set(4,8);
        cache.set(5,10);
        cache.set(6,12);
        int k1=cache.get(2);
        int k2=cache.get(3);
        int k3=cache.get(4);
        int k4=cache.get(5);
        int k5=cache.get(6);
    }

}