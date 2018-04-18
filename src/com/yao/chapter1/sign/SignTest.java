package com.yao.chapter1.sign;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yao.annotation.annotation.PrintMe;

@PrintMe
public class SignTest {
	
	@PrintMe
	public static void main(String[] args) throws UnsupportedEncodingException {
		String sign = "076dc36bddfd39fa987657e89bd1fd3d";
		System.out.println(sign.equals("076dc36bddfd39fa987657e89bd1fd3d"));

		HashMap<String, Object> map = new HashMap<>();
		map.put("appChannel", "GooglePlay");
		// map.put("appKey", "android_lk98f83");
		// map.put("appTimestamp", "1513929431686");
		map.put("appTypeId", "0");
		map.put("appVersion", "6.11.2");
		map.put("cookieId", "511cad5b-6ae2-49a0-b644-b69a2660ba94");
		map.put("countryCode", "HK");
		map.put("currency", "HKD");
		map.put("lang", "0");
		map.put("parentId", 1876);
		map.put("seq", 1876);
		// map.put("sign", "");
		map.put("terminalType", "1");
		map.put("userId", "14963605");
		map.put("userToken", "Mmnk8V5gDSz0pegyf7aUcgQQ");

		// String str1 = createSign(map, false);
		// System.out.println(str1);
		// String str2 = createSign(map, true);
		// System.out.println(str2);
		System.out.println("********************");
		SignBuilder builder = new SignBuilder();

		// System.out.println(builder.sign(map, "flvjk342589fdgjl34m9sdufg234oiy"));
		System.out.println(doSign(map, "flvjk342589fdgjl34m9sdufg234oiy"));

		builder.getRegionList(1876);

		System.out.println("********************");
		SaltHandle handle = new SaltHandle();
		System.out.println(handle.handle("291 336 336 258 303 342 345 315 333 330"));

		System.out.println("********************");
		Salt salt = new Salt();
		System.out.println(handle.handle(salt.a()));

		System.out.println(handle.handle(salt.b()));

		System.out.println(handle.handle(salt.c()));

		System.out.println(handle.handle(salt.d()));

		System.out.println(handle.handle(salt.e()));

		System.out.println(handle.handle(salt.f()));

		System.out.println(handle.handle(salt.g()));

		System.out.println(handle.handle(salt.h()));
		System.out.println("*********************");

	}

	public static String doSign(HashMap<String, Object> map, String salt) {

		Set<String> keySet = map.keySet();
		String[] localKey = keySet.toArray(new String[keySet.size()]);
		Arrays.sort(localKey);
		StringBuffer temp = new StringBuffer();

		int j = localKey.length;
		int i = 0;
		while (i < j) {
			String key = localKey[i];
			temp.append(key);
			Object value = map.get(key);
			temp.append(value);
			i += 1;
		}
		String param = salt + temp.toString() + salt;
		return MD5Utils.getMD5(param);
	}

	public static String createSign(Map<String, Object> params, boolean encode) throws UnsupportedEncodingException {
		Set<String> keysSet = params.keySet();
		Object[] keys = keysSet.toArray();
		Arrays.sort(keys);
		StringBuffer temp = new StringBuffer();
		boolean first = true;
		for (Object key : keys) {
			if (first) {
				first = false;
			} else {
				temp.append("&");
			}
			temp.append(key).append("=");
			Object value = params.get(key);
			String valueString = "";
			if (null != value) {
				valueString = String.valueOf(value);
			}
			if (encode) {
				temp.append(URLEncoder.encode(valueString, "UTF-8"));
			} else {
				temp.append(valueString);
			}
		}
		return MD5Utils.md5(temp.toString());
	}

	static class MD5Utils {
		public static String getMD5(String str) {
			MessageDigest messageDigest = null;
			try {
				messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.reset();
				messageDigest.update(str.getBytes("UTF-8"));
			} catch (NoSuchAlgorithmException e) {
				System.out.println("NoSuchAlgorithmException caught!");
				System.exit(-1);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			byte[] byteArray = messageDigest.digest();
			StringBuffer md5StrBuff = new StringBuffer();

			for (int i = 0; i < byteArray.length; i++) {
				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
					md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
				else
					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
			return md5StrBuff.toString();
		}

		public static String md5(String content) {
			byte[] hash;
			try {
				hash = MessageDigest.getInstance("MD5").digest(content.getBytes("UTF-8"));
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException("NoSuchAlgorithmException", e);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("UnsupportedEncodingException", e);
			}

			StringBuilder hex = new StringBuilder(hash.length * 2);
			for (byte b : hash) {
				if ((b & 0xFF) < 0x10) {
					hex.append("0");
				}
				hex.append(Integer.toHexString(b & 0xFF));
			}
			return hex.toString();
		}
	}
}
