package com.yao.chapter1.type;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

public class GenericArrayTypeBean<T> {
	public void test(List<String>[] pTypeArray, T[] vTypeArray, List<String> list, String[] strings, Person[] ints) {
	}

	public static void main(String[] args) {
		testGenericArrayType();
	}

	private static void testGenericArrayType() {
		Method[] methods = GenericArrayTypeBean.class.getDeclaredMethods();
		Method method = null;
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equals("test")) {
				method = methods[i];
				System.out.println(method);
			}
		}
		if (method != null) {
			Type[] types = method.getGenericParameterTypes();
			for (Type type : types) {
				System.out.println(type instanceof GenericArrayType);
			}
		}

	}
}
