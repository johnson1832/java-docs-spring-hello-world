package com.example.demo.model;

public class Thing {

	String key;
	String value;
	String source;
	String expected;
	
	public Thing () { 		
	}

	public Thing(String key, String value, String source, String expected) {
		super();
		this.key = key;
		this.value = value;
		this.source = source;
		this.expected = expected;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}
}
