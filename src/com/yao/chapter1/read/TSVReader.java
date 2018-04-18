package com.yao.chapter1.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class TSVReader {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ObjectInputStream objIS = null;
		try {
			FileReader reader = new FileReader(new File("/home/yaopaine/Documents/AndroidProjects/country.txt"));
			BufferedReader bufferReader = new BufferedReader(reader);
			List<Country> list = new ArrayList<>(250);
			String str = null;

			while ((str = bufferReader.readLine()) != null) {
				String[] arry = str.split("	");
				int length = arry.length;
				Country country = new Country();
				for (int i = 0; i < length; i++) {
					if (i == 0) {
						country.setShortName(arry[i]);
					} else if (i == 1) {
						country.setCountryName(arry[i]);
					} else if (i == 2) {
						country.setCode(arry[i]);
					} else if (i == 3) {
						country.setPhoneLength(arry[i]);
					} else if (i == 4) {
						country.setName(arry[i]);
					}
				}
				list.add(country);
			}
			bufferReader.close();
			reader.close();

			Gson gson = new Gson();
			String json = gson.toJson(list);
			System.out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (objIS != null) {
				try {
					objIS.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
