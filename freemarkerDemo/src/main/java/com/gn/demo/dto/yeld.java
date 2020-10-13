package com.gn.demo.dto;

public class yeld {
 
	public static void main(String[] args) {
		ThreadDemo demo = new ThreadDemo();
		Thread thread = new Thread(demo, "花花");
		Thread thread1 = new Thread(demo, "草草");
		thread.start();
		thread1.start();
	}
}

