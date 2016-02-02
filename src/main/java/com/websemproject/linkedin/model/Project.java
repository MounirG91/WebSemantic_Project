package com.websemproject.linkedin.model;

import java.util.Iterator;
import java.util.List;

public class Project{
	private String title, link, start_date, end_date, description,duration;
	private List<String> associates;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Project(String title, String link, String start_date, String end_date, String description, String duration) {
		super();
		this.title = title;
		this.link = link;
		this.start_date = start_date;
		this.end_date = end_date;
		this.description = description;
		this.duration = duration;
		
	}

	public Project(String title, String link, String start_date, String end_date, String description, String duration,
			List<String> associates) {
		super();
		this.title = title;
		this.link = link;
		this.start_date = start_date;
		this.end_date = end_date;
		this.description = description;
		this.associates = associates;
	}

	public String getTitle() {
		return title;
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

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getAssociates() {
		return associates;
	}

	public void setAssociates(List<String> associates) {
		this.associates = associates;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Project [title=" + title + ", link=" + link + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", description=" + description +  ", associates=" + associates + "]";
	}

	public void showAllAssociates() throws NullPointerException {
		Iterator<String> iterator = this.getAssociates().iterator();
		while (iterator.hasNext()) {
			String associate = iterator.next();
			System.out.println(associate.toString());
		}
	}

}
