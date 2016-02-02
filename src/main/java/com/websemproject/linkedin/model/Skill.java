package com.websemproject.linkedin.model;


public class Skill{
	private String name, firstAppeared, paradigm, lastVersion, designedBy, developer, licence, website;

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skill(String name, String firstAppeared, String paradigm, String lastVersion, String designedBy,
			String developer, String licence, String website) {
		super();
		this.name = name;
		this.firstAppeared = firstAppeared;
		this.paradigm = paradigm;
		this.lastVersion = lastVersion;
		this.designedBy = designedBy;
		this.developer = developer;
		this.licence = licence;
		this.website = website;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstAppeared() {
		return firstAppeared;
	}

	public void setFirstAppeared(String firstAppeared) {
		this.firstAppeared = firstAppeared;
	}

	public String getParadigm() {
		return paradigm;
	}

	public void setParadigm(String paradigm) {
		this.paradigm = paradigm;
	}

	public String getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(String lastVersion) {
		this.lastVersion = lastVersion;
	}

	public String getDesignedBy() {
		return designedBy;
	}

	public void setDesignedBy(String designedBy) {
		this.designedBy = designedBy;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Skill [name=" + name + ", firstAppeared=" + firstAppeared + ", paradigm=" + paradigm + ", lastVersion="
				+ lastVersion + ", designedBy=" + designedBy + ", developer=" + developer + ", licence=" + licence
				+ ", website=" + website + "]";
	}
	
	

}
