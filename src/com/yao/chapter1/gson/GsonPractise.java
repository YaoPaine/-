package com.yao.chapter1.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yao.chapter1.read.Country;

public class GsonPractise {

	public static void main(String[] args) {

		// Gson gson = new Gson();

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();

		/*
		 * Void voidClazz = gson.fromJson("true", Void.class);报错
		 * System.out.println(voidClazz);
		 */

		String str = gson.fromJson("true", String.class);
		System.out.println("str:**" + str + "**:str");

		/*
		 * Boolean bool = gson.fromJson("true", Boolean.class);
		 * System.out.println("bool:**" + bool + "**:bool");
		 */

		/*
		 * Country country = gson.fromJson("true", Country.class);报错
		 * System.out.println("country:**" + country + "**:country");
		 */

		/*
		 * Void voidClazz2 = gson.fromJson("{}", Void.class);
		 * System.out.println("voidClazz2:**" + voidClazz2 + "**:voidClazz2");
		 */

		/*
		 * String str2 = gson.fromJson("{}", String.class);报错
		 * System.out.println("str2:**" + str2 + "**:str2");
		 */

		/*
		 * Country country2 = gson.fromJson("{}", Country.class);
		 * System.out.println("country2:**" + country2 + "**:country2");
		 */

		/*
		 * Boolean bool2 = gson.fromJson("{}", Boolean.class);报错
		 * System.out.println("bool2:**" + bool2 + "**:bool2");
		 */

		/*
		 * Boolean bool2 = gson.fromJson("{true}", Boolean.class);报错
		 * System.out.println("bool2:**" + bool2 + "**:bool2");
		 */

		/*
		 * String bool2 = gson.fromJson("{true}", String.class);报错
		 * System.out.println("bool2:**" + bool2 + "**:bool2");
		 */
	}

}
