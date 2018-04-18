package com.yao.chapter1.type;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class TypeVariableTest {

	public static void main(String... args) throws Exception {
		TypeVariableBean<FileInputStream, String> bean = new TypeVariableBean<>();
		Field field = TypeVariableBean.class.getDeclaredField("key");
		Type type = field.getGenericType();

		if (type instanceof TypeVariable) {
			TypeVariable tType = (TypeVariable) type;
			System.out.println(tType.getName());
			System.out.println(tType.getGenericDeclaration());
			System.out.println(Arrays.toString(tType.getBounds()));
			System.out.println(Arrays.toString(tType.getAnnotatedBounds()));
		}

	}

}
