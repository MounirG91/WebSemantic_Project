package com.websemproject.linkedin.model;


public class University{
	private String name, foundedIn, type, website, director, numberOfStudents, numberOfTeachers, languageRegime, adres;

	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

	public University(String name, String foundedIn, String type, String website, String director,
			String numberOfStudents, String numberOfTeachers, String languageRegime, String adres) {
		super();
		this.name = name;
		this.foundedIn = foundedIn;
		this.type = type;
		this.website = website;
		this.director = director;
		this.numberOfStudents = numberOfStudents;
		this.numberOfTeachers = numberOfTeachers;
		this.languageRegime = languageRegime;
		this.adres = adres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoundedIn() {
		return foundedIn;
	}

	public void setFoundedIn(String foundedIn) {
		this.foundedIn = foundedIn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(String numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getNumberOfTeachers() {
		return numberOfTeachers;
	}

	public void setNumberOfTeachers(String numberOfTeachers) {
		this.numberOfTeachers = numberOfTeachers;
	}

	public String getLanguageRegime() {
		return languageRegime;
	}

	public void setLanguageRegime(String languageRegime) {
		this.languageRegime = languageRegime;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", foundedIn=" + foundedIn + ", type=" + type + ", website=" + website
				+ ", director=" + director + ", numberOfStudents=" + numberOfStudents + ", numberOfTeachers="
				+ numberOfTeachers + ", languageRegime=" + languageRegime + ", adres=" + adres + "]";
	}
	
	

}
