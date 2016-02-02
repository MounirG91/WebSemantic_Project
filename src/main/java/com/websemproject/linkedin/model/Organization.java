package com.websemproject.linkedin.model;


public class Organization{

	private String name, link;

	public Organization(String name, String link) {
		super();
		this.name = name;
		this.link = link;
	}

	@Override
	public String toString() {
		return "Organization [name=" + name + ", link=" + link + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
