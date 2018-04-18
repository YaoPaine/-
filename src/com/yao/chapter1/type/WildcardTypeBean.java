package com.yao.chapter1.type;

import java.util.List;

public class WildcardTypeBean {
	private List<? extends Number> a;
	private List<? super Integer> b;
	private List<String> c;
	private Class<?> aClass;

}
