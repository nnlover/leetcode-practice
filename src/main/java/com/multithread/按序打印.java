package com.multithread;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/14 22:53
 */
public class 按序打印 {
}
class Foo1 {

	/**
	 * 利用线程间共享变量
	 */
	volatile int num = 1;

	public Foo1() {

	}

	public void first(Runnable printFirst) throws InterruptedException {

		while (num != 1){
		}
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		num = 2;
	}

	public void second(Runnable printSecond) throws InterruptedException {
		while (num != 2){
		}
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		num = 3;
	}

	public void third(Runnable printThird) throws InterruptedException {
		while (num != 3){
		}
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}
