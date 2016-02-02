package com.websemproject.linkedin.model;


public class JobCompany{
	private String title, company, description, duration, start_date, linkedin_company_url, url, website, industry,
			type, headquarters, company_size, founded, address;
	private JobCompany jobCompany;

	public JobCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobCompany(String title, String company, String description, String duration, String start_date,
			String linkedin_company_url, String url, String website, String industry, String type, String headquarters,
			String company_size, String founded, String address) {
		super();
		this.title = title;
		this.company = company;
		this.description = description;
		this.duration = duration;
		this.start_date = start_date;
		this.linkedin_company_url = linkedin_company_url;
		this.url = url;
		this.website = website;
		this.industry = industry;
		this.type = type;
		this.headquarters = headquarters;
		this.company_size = company_size;
		this.founded = founded;
		this.address = address;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getLinkedin_company_url() {
		return linkedin_company_url;
	}

	public void setLinkedin_company_url(String linkedin_company_url) {
		this.linkedin_company_url = linkedin_company_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public String getCompany_size() {
		return company_size;
	}

	public void setCompany_size(String company_size) {
		this.company_size = company_size;
	}

	public String getFounded() {
		return founded;
	}

	public void setFounded(String founded) {
		this.founded = founded;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public JobCompany getJobCompany() {
		return jobCompany;
	}

	public void setJobCompany(JobCompany jobCompany) {
		this.jobCompany = jobCompany;
	}

	@Override
	public String toString() {
		return "JobCompany [title=" + title + ", company=" + company + ", description=" + description + ", duration="
				+ duration + ", start_date=" + start_date + ", linkedin_company_url=" + linkedin_company_url + ", url="
				+ url + ", website=" + website + ", industry=" + industry + ", type=" + type + ", headquarters="
				+ headquarters + ", company_size=" + company_size + ", founder=" + founded + ", address=" + address
				+ "]";
	}

}
