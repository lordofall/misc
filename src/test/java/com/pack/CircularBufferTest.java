package com.pack;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularBufferTest {

	CircularBuffer buffer = new CircularBuffer(2);
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

	@Test
	public void offerTest() {
		assertTrue(buffer.offer("a"));
		assertTrue(buffer.offer("b"));
		assertFalse(buffer.offer("c"));
	}
	
	@Test
	public void pollTest() {
		assertEquals(2, buffer.size());
		buffer.offer("a");
		assertTrue(buffer.poll() != null);
		assertTrue(buffer.poll() == null);
	}
}
