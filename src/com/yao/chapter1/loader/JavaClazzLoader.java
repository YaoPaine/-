package com.yao.chapter1.loader;

public class JavaClazzLoader {

	public static void main(String[] args) {
		System.out.println(FinalTest1.NUM);
		System.out.println(FinalTest2.NUM);
		// 为什么没有打印出hello1、hello2，涉及到Java类加载条件

		/*
		 * 那么我们什么时候类需要加载呢?
		 * 
		 * 当我们首次主动使用这个类的时候,类需要被加载.
		 * 
		 * 那什么是“主动使用”呢？
		 * 
		 * 创建对象的实例：
		 * 
		 * 1、我们new对象的时候，会引发类的初始化，前提是这个类没有被初始化。
		 * 
		 * 2、调用类的静态属性或者为静态属性赋值
		 * 
		 * 3、调用类的静态方法
		 * 
		 * 4、通过class文件反射创建对象
		 * 
		 * 5、初始化一个类的子类：使用子类的时候先初始化父类
		 * 
		 * 6、java虚拟机启动时被标记为启动类的类：就是我们的main方法所在的类
		 * 
		 * 只有上面6种情况才是主动使用，也只有上面六种情况的发生才会引发类的初始化。
		 * 
		 * 同时我们需要注意下面几个Tips:
		 * 
		 * 1、在同一个类加载器下面只能初始化类一次,如果已经初始化了就不必要初始化了.
		 * 这里多说一点，为什么只初始化一次呢？因为我们上面讲到过类加载的最终结果就是在堆中存有唯一一个Class对象，我们通过Class对象找到
		 * 类的相关信息。唯一一个Class对象说明了类只需要初始化一次即可，如果再次初始化就会出现多个Class对象，这样和唯一相违背了。
		 * 
		 * 2、在编译的时候能确定下来的静态变量(编译常量),不会对类进行初始化;
		 * 
		 * 3、在编译时无法确定下来的静态变量(运行时常量),会对类进行初始化;
		 * 
		 * 4、如果这个类没有被加载和连接的话,那就需要进行加载和连接
		 * 
		 * 5、如果这个类有父类并且这个父类没有被初始化,则先初始化父类.
		 * 
		 * 6、如果类中存在初始化语句,依次执行初始化语句.
		 * 
		 * 作者：Anderson大码渣 链接：https://www.jianshu.com/p/d03e0d36ec15
		 */

		// FinalTest1 test1 = new FinalTest1();
	}

}

class FinalT {
	static {
		System.out.println("hello1");
	}

	public FinalT() {
		System.out.println("hello--FinalT");
	}
}

class FinalTest1 extends FinalT {
	public static final int NUM = 3;
	static {
		System.out.println("hello3");
	}

	public FinalTest1() {
		// super();
		System.out.println("hello--FinalTest1");
	}
}

class FinalTest2 {
	public static int NUM = 5;
	static {
		System.out.println("hello5");
	}
}
