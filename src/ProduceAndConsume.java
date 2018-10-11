package me.cwuyi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by XIA on 2017/7/7.
 */
public class ProduceAndConsume {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] cache = new Object[100];
    private int produceIndex, comsumeIndex, count;

    public void produce(Object o) {
        lock.lock();
        try {
            while (count >= cache.length) {
                notFull.await();
            }
            cache[produceIndex] = o;
            if (++produceIndex == cache.length) produceIndex = 0;
            count++;
            System.out.println("produce index: " + produceIndex + " and thread:" + Thread.currentThread().getId());
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object consume() {
        lock.lock();
        Object x = null;
        try {
            while (count == 0) {
                notEmpty.await();
            }
            x = cache[comsumeIndex];
            if (++comsumeIndex == cache.length) comsumeIndex = 0;
            --count;
            System.out.println("consume index: " + comsumeIndex + " and thread:" + Thread.currentThread().getId());
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return x;
    }

    public static void main(String[] args) {
        ProduceAndConsume pc = new ProduceAndConsume();

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pc.consume();
                }
            }).start();
        }

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pc.produce(new Object());
                }
            }).start();
        }
    }


}
