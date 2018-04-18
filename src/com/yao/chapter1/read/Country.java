package com.yao.chapter1.read;

import java.io.Serializable;

public class Country implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5012697570500660287L;

	private String shortName;

	private String countryName;

	private String code;

	private String phoneLength;

	private String name;

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhoneLength() {
		return phoneLength;
	}

	public void setPhoneLength(String phoneLength) {
		this.phoneLength = phoneLength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [shortName=" + shortName + ", countryName=" + countryName + ", code=" + code + ", phoneLength="
				+ phoneLength + ", name=" + name + "]";
	}
	
	
}
