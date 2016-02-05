package com.websemproject.linkedin.controller;

public class MentionnedLanguage {
	private String name, fluent;

	public MentionnedLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MentionnedLanguage(String name, String fluent) {
		super();
		this.name = name;
		this.fluent = fluent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFluent() {
		return fluent;
	}

	public void setFluent(String fluent) {
		this.fluent = fluent;
	}

}
