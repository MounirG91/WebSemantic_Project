package com.websemproject.linkedin.controller;

public class MentionedProfessional {

	private String name, degree, sameUniversity, workedInSameCompany, isColleague;

	public MentionedProfessional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MentionedProfessional(String name, String degree, String sameUniversity, String workedInSameCompany,
			String isColleague) {
		super();
		this.name = name;
		this.degree = degree;
		this.sameUniversity = sameUniversity;
		this.workedInSameCompany = workedInSameCompany;
		this.isColleague = isColleague;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSameUniversity() {
		return sameUniversity;
	}

	public void setSameUniversity(String sameUniversity) {
		this.sameUniversity = sameUniversity;
	}

	public String getWorkedInSameCompany() {
		return workedInSameCompany;
	}

	public void setWorkedInSameCompany(String workedInSameCompany) {
		this.workedInSameCompany = workedInSameCompany;
	}

	public String getIsColleague() {
		return isColleague;
	}

	public void setIsColleague(String isColleague) {
		this.isColleague = isColleague;
	}

}
