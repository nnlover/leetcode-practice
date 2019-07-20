package com.multithread;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/15 00:03
 * 尝试用 cycleBarrier 来解决但是有个问题就是无法控制谁先执行，还需要额外加一个变量才可以控制，那么这个额外变量只要加在循环里面就可以去掉cycleBarrier了；
 * 应该还有更好的解决办法，但是太困了就不想了；
 * 出现的问题：调用 wait 方法报错： java.lang.IllegalMonitorStateException
 * <p>
 * ¬
 */
public class PrintFoobarAlternately {
	public static void main2(String[] args) {

		FooBar fooBar = new FooBar(50);
		new Thread(() -> {
			try {
				fooBar.foo(() -> System.out.print("foo"));
			} catch (InterruptedException e) {
			}
		}).start();
		new Thread(() -> {
			try {
				fooBar.bar(() -> System.out.println("bar"));
			} catch (InterruptedException e) {
			}
		}).start();


	}
}

class FooBar {
	volatile boolean start = true;
	private int n;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			while (start != true) {
			}
			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();
			start = false;
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			while (start != false) {
			}
			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();
			start = true;
		}
	}
}

