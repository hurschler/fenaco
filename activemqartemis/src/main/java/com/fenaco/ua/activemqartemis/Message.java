package com.fenaco.ua.activemqartemis;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private static volatile int counter = 0;
	private int id;
	private String text;
	private String base64;
	
	public Message() {
		
	}
	
	public Message(String text, String base64) {
		this.text = text;
		this.base64 = base64;
	}
 	
	public Message(String text) {
		counter++;
		this.id = counter;
		this.text = text;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}
	
	
}
