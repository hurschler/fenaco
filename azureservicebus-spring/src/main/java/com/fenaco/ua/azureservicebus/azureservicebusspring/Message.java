package com.fenaco.ua.azureservicebus.azureservicebusspring;

import java.io.Serializable;

public class Message implements Serializable {
	private static volatile int counter = 0;
	private int id;
	private String text;

	private static final long serialVersionUID = -295422703255886286L;

	
	public Message() {
		
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
	
	
}
