package com.gn.demo.dto;

import java.util.LinkedList;

public class ThreadDemo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			if (i == 3) {
				System.out.println("当前的线程是     " + Thread.currentThread().getName());
				Thread.yield();
			}
			System.out.println("执行的是    " + Thread.currentThread().getName());
		}

	}

}