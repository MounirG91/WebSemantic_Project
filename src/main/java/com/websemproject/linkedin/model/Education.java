package com.websemproject.linkedin.model;


public class Education {
	private String name, description, degree, major, period, start_date, end_date;
	private University university;

	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Education(String name, String description, String degree, String major, String period, String start_date,
			String end_date) {
		super();
		this.name = name;
		this.description = description;
		this.degree = degree;
		this.major = major;
		this.period = period;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "Education [name=" + name + ", description=" + description + ", degree=" + degree + ", major=" + major
				+ ", period=" + period + ", start_date=" + start_date + ", end_date=" + end_date + "] + "+university.toString();
	}

}
