package com.fenaco.ua.rabbitmq;

public class Message {
	
	private static int counter = 0;
	private int id;
	private String text;
	
	public Message(String text) {
		counter++;
		this.id = counter;
		this.text = text;
		
	}
	
	public Message() {
		
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
