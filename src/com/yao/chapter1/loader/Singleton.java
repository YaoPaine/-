package com.yao.chapter1.loader;

public class Singleton {

	public static void main(String[] args) {
		Single single = Single.getInstance();
		System.out.print(single.a1);
		System.out.print(single.a2);
		//为什么是10，而不是11，涉及到Java类加载步骤
	}

}

class Single {
	private static Single instance = new Single();
	public static int a1;
	public static int a2 = 0;

	public Single() {
		a1++;
		a2++;
	}

	public static Single getInstance() {
		return instance;
	}
}
