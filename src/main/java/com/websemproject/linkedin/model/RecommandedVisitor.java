package com.websemproject.linkedin.model;


public class RecommandedVisitor {

	private String title, link, name, company;
	
	

	public RecommandedVisitor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecommandedVisitor(String name, String title, String link, String company) {
		super();
		this.name = name;
		this.title = title;
		this.link = link;
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "RecommandedVisitor [title=" + title + ", link=" + link + ", name=" + name + ", company=" + company
				+ "]";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
