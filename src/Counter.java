package tutorial.impl;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger value = new AtomicInteger();
	public int getValue(){
		return value.get();
	}
	public int increment(){
		return value.incrementAndGet();
	}
}
