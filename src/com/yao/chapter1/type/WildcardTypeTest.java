package com.yao.chapter1.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

public class WildcardTypeTest {

	public static void main(String[] args) throws Exception {
		Field[] fields = WildcardTypeBean.class.getDeclaredFields();

		for (Field field : fields) {
			Type type = field.getGenericType();
			String name = type.getTypeName();
			System.out.println("下面开始打印" + name + "是否具有通配符");
			if (!(type instanceof ParameterizedType)) {
				System.out.println("---------------------------");
				continue;
			}
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type t = parameterizedType.getActualTypeArguments()[0];
			if (!(t instanceof WildcardType)) {
				System.out.println("---------------------------");
				continue;
			}

			WildcardType wildcardType = (WildcardType) t;
			Type[] type1 = wildcardType.getLowerBounds();
			if (type1 != null) {
				System.out.println("下边界");
				System.out.println(Arrays.toString(type1));
			}
			Type[] type2 = wildcardType.getUpperBounds();
			if (type2 != null) {
				System.out.println("上边界");
				System.out.println(Arrays.toString(type2));
			}
			System.out.println("---------------------------");
		}
		Field fieldA = WildcardTypeBean.class.getDeclaredField("a");
		Field fieldB = WildcardTypeBean.class.getDeclaredField("b");

		// 先拿到范型类型
		System.out.println(fieldA.getGenericType() instanceof ParameterizedType);
		System.out.println(fieldB.getGenericType() instanceof ParameterizedType);
	}

}
