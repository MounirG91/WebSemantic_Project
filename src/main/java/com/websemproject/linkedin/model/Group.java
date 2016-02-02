package com.websemproject.linkedin.model;



public class Group {
	private String name, link;

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Group(String name, String link) {
		super();
		this.name = name;
		this.link = link;
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

	@Override
	public String toString() {
		return "Group [name=" + name + ", link=" + link + "]";
	}

	
}
