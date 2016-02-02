package com.websemproject.linkedin.model;



public class Certification {
	private String title, score;
	private String relatedSkill, createdBy, administredBy, maximumScore, website;

	public Certification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certification(String title, String score) {
		super();
		this.title = title;
		this.score = score;
	}

	public Certification(String title, String score, String relatedSkill, String createdBy, String administredBy,
			String maximumScore, String website) {
		super();
		this.title = title;
		this.score = score;
		this.relatedSkill = relatedSkill;
		this.createdBy = createdBy;
		this.administredBy = administredBy;
		this.maximumScore = maximumScore;
		this.website = website;
	}

	public String getRelatedSkill() {
		return relatedSkill;
	}

	public void setRelatedSkill(String relatedSkill) {
		this.relatedSkill = relatedSkill;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAdministredBy() {
		return administredBy;
	}

	public void setAdministredBy(String administredBy) {
		this.administredBy = administredBy;
	}

	public String getMaximumScore() {
		return maximumScore;
	}

	public void setMaximumScore(String maximumScore) {
		this.maximumScore = maximumScore;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Certification [title=" + title + ", score=" + score + ", relatedSkill=" + relatedSkill + ", createdBy="
				+ createdBy + ", administredBy=" + administredBy + ", maximumScore=" + maximumScore + ", website="
				+ website + "]";
	}

}