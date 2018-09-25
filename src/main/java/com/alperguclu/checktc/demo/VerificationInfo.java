package com.alperguclu.checktc.demo;

public class VerificationInfo {
	private String name;
	private String surname;
	private int yearOfBirth;
	private long tc;
	private boolean result;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public long getTc() {
		return tc;
	}
	public void setTc(long tc) {
		this.tc = tc;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
}
