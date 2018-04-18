package com.yao.chapter1.loader;

public class Test1 {
	public static void main(String[] args) {
		System.out.println(FinalTest.NUM);
		System.out.println(FinalTest3.NUM);
	}
}

class FinalTest {
	public static final int NUM = 3;
	static {
		System.out.println("hello");
	}
}

class FinalTest3 {
	public static int NUM = 5;
	static {
		System.out.println("hello1");
	}
}
