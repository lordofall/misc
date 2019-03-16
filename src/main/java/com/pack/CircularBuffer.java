package com.pack;

/**
 * its a queue so first-in-first-out. How it is different from traditional queue is, 
 * 
 * if we poll a value from the circular buffer, you can add a value.
 * @author LordOfAll
 *
 */
public class CircularBuffer {
	
	private Object[] buffer;
	int readCursor = 0;
	int writeCursor = 0;
	public CircularBuffer(int size) {
		buffer = new String[size];
	}
	
	/**
	 * add a value in the buffer. 
	 * 1) if buffer[writeCursor] = null, then you add the value at that position, and update 
	 * the writeCursor value.
	 * 2)if its not null, then buffer is full and return false
	 * @param str
	 */
	public boolean offer(Object str) {
		if(buffer[writeCursor] == null) {
			buffer[writeCursor] = str;
			writeCursor = next(writeCursor);
			return true;
		}
		return false;
	}

	/**
	 * 1)if buffer[readCursor] != null, return the same. update the value to null. 
	 * update the readCursor.
	 * 2)if buffer[readCursor] = null, return null.
	 * @return
	 */
	public Object poll() {
		Object obj = buffer[readCursor]; 
		if(obj != null) {
			readCursor = next(readCursor);
			buffer[readCursor] = null; // value is popped, so now its null
		}
		return obj;
	}
	private int next(int cursor) {
		if(cursor == buffer.length-1) {
			cursor = 0;
		}
		else {
			cursor++;
		}
		return cursor;
	}
	
	public int size() {
		return buffer.length;
	}
	
}
