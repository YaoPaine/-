package com.yao.chapter1.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ParameterTypeTest {

	public static void main(String[] args) {

		/*
		 * Field[] fields = ParameterizedTypeBean.class.getDeclaredFields(); for (Field
		 * field : fields) { System.out.println(field.getName() +
		 * "\tgetGenericType() instanceof ParameterizedType： " + (field.getGenericType()
		 * instanceof ParameterizedType)); }
		 */

		getParameterizedTypeMes("map");
		getParameterizedTypeMes("entry");
	}

	private static void getParameterizedTypeMes(String fieldName) {
		System.out.println("********************");
		Field f;
		try {
			f = ParameterizedTypeBean.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			// java.util.Map<java.lang.String, com.yao.chapter1.type.Person>
			System.out.println(f.getGenericType());
			boolean b = f.getGenericType() instanceof ParameterizedType;
			System.out.println(b);
			if (b) {
				ParameterizedType pType = (ParameterizedType) f.getGenericType();
				// java.util.Map<java.lang.String, com.yao.chapter1.type.Person>
				System.out.println("getTypeName: " + pType.getTypeName());
				for (Type type : pType.getActualTypeArguments()) {
					
					System.out.println(type.getTypeName() + "**" + type);
				}
				System.out.println(pType.getOwnerType());
			}
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
