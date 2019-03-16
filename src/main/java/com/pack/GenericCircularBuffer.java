package com.pack;

import java.lang.reflect.Array;

public class GenericCircularBuffer<T> {

	
	private T[] buffer;
	int readCursor = 0;
	int writeCursor = 0;
	public GenericCircularBuffer(int size) {
//		buffer = new T[size]; // wont work
//		buffer = (T[]) Array.newInstance(c, size);
		buffer = (T[]) new Object[size];
	}
	
	/**
	 * add a value in the buffer. 
	 * 1) if buffer[writeCursor] = null, then you add the value at that position, and update 
	 * the writeCursor value.
	 * 2)if its not null, then buffer is full and return false
	 * @param str
	 */
	public boolean offer(T str) {
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
	public T poll() {
		T obj = buffer[readCursor]; 
		if(obj != null) {
			readCursor = next(readCursor);
			buffer[readCursor] = null; // value is popped, so now its null
		}
		return obj;
	}
	private int next(int index) {
		return (index+1) % buffer.length;
	}
	
	public int size() {
		return buffer.length;
	}
	

}
