package com.websemproject.linkedin.model;

import java.util.Iterator;
import java.util.List;

public class Professional {
	private String name, first_name, last_name, title, location, number_of_connections, country, industry, summary,
			picture, linkedin_url, link;
	private List<String> websites, skills, languages;
	private List<JobCompany> past_companies, current_companies;
	private List<Organization> organizations;
	private List<Friend> friends;
	private List<RecommandedVisitor> recommended_visitors;
	private List<Group> groups;
	private List<Certification> certifications;
	private List<Education> education;
	private List<Project> projects;
	private List<Skill> skillsAll;

	public Professional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professional(String name, String first_name, String last_name, String title, String location,
			String number_of_connections, String country, String industry, String summary, String picture,
			String linkedin_url, String link, List<String> websites, List<String> skills, List<String> languages,
			List<Organization> organizations, List<JobCompany> past_companies, List<JobCompany> current_companies,
			List<Friend> friends, List<RecommandedVisitor> recommended_visitors, List<Group> groups,
			List<Certification> certifications, List<Education> education, List<Project> projects) {
		super();
		this.name = name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.title = title;
		this.location = location;
		this.number_of_connections = number_of_connections;
		this.country = country;
		this.industry = industry;
		this.summary = summary;
		this.picture = picture;
		this.linkedin_url = linkedin_url;
		this.websites = websites;
		this.skills = skills;
		this.languages = languages;
		this.organizations = organizations;
		this.past_companies = past_companies;
		this.current_companies = current_companies;
		this.friends = friends;
		this.recommended_visitors = recommended_visitors;
		this.groups = groups;
		this.certifications = certifications;
		this.education = education;
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Professional [name=" + name + ", first_name=" + first_name + ", last_name=" + last_name + ", title="
				+ title + ", location=" + location + ", number_of_connections=" + number_of_connections + ", country="
				+ country + ", industry=" + industry + ", summary=" + summary + ", picture=" + picture
				+ ", linkedin_url=" + linkedin_url + ", link=" + link + ", websites=" + websites + ", skills=" + skills
				+ ", languages=" + languages + "]";
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNumber_of_connections() {
		return number_of_connections;
	}

	public void setNumber_of_connections(String number_of_connections) {
		this.number_of_connections = number_of_connections;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getLinkedin_url() {
		return linkedin_url;
	}

	public void setLinkedin_url(String linkedin_url) {
		this.linkedin_url = linkedin_url;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<String> getWebsites() {
		return websites;
	}

	public void setWebsites(List<String> websites) {
		this.websites = websites;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public List<JobCompany> getPast_companies() {
		return past_companies;
	}

	public void setPast_companies(List<JobCompany> past_companies) {
		this.past_companies = past_companies;
	}

	public List<JobCompany> getCurrent_companies() {
		return current_companies;
	}

	public void setCurrent_companies(List<JobCompany> current_companies) {
		this.current_companies = current_companies;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}


	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	public List<RecommandedVisitor> getRecommended_visitors() {
		return recommended_visitors;
	}

	public void setRecommended_visitors(List<RecommandedVisitor> recommended_visitors) {
		this.recommended_visitors = recommended_visitors;
	}

	public void showAllFriends(List<Friend> friends) {
		Iterator<Friend> iterator = friends.iterator();
		while (iterator.hasNext()) {
			Friend professional = iterator.next();
			System.out.println(professional.toString());
		}
	}

	public void showAllRecommended_visitor(List<RecommandedVisitor> list) {
		Iterator<RecommandedVisitor> iterator = list.iterator();
		while (iterator.hasNext()) {
			RecommandedVisitor recommended_visitor = iterator.next();
			System.out.println(recommended_visitor.toString());
		}
	}

	public void showAllEducations(List<Education> education) {
		Iterator<Education> iterator = education.iterator();
		while (iterator.hasNext()) {
			Education educat = iterator.next();
			System.out.println(educat.toString());
		}
	}

	public void showAllCertifications(List<Certification> certifications) throws NullPointerException {
		Iterator<Certification> iterator = certifications.iterator();
		while (iterator.hasNext()) {
			Certification certification = iterator.next();
			System.out.println(certification.toString());
		}
	}

	public void showAllProjects(List<Project> projects) {
		Iterator<Project> iterator = projects.iterator();
		while (iterator.hasNext()) {
			Project project = iterator.next();
			System.out.println(project.toString());
			// project.showAllAssociates();
		}
	}

	public void showAllGroups(List<Group> groups) {
		Iterator<Group> iterator = groups.iterator();
		while (iterator.hasNext()) {
			Group group = iterator.next();
			System.out.println(group.toString());
		}
	}

	public void showAllOrganizations(List<Organization> list) {
		Iterator<Organization> iterator = organizations.iterator();
		while (iterator.hasNext()) {
			Organization organization = iterator.next();
			System.out.println(organization.toString());
		}
	}

	public void showAllJobCompany(List<JobCompany> jobs) {
		System.out.println("************Past jobs ************");
		Iterator<JobCompany> iterator = jobs.iterator();
		while (iterator.hasNext()) {
			JobCompany job = iterator.next();
			System.out.println(job.toString());
		}
	}

	public void showCurrentJobCompany(List<JobCompany> jobs) {
		System.out.println("************Current jobs ************");
		Iterator<JobCompany> iterator = jobs.iterator();
		while (iterator.hasNext()) {
			JobCompany job = iterator.next();
			System.out.println(job.toString());
		}
	}
	
	public void showAllSkills(List<Skill> skills) {
		System.out.println("************Skills ************");
		Iterator<Skill> iterator = skills.iterator();
		while (iterator.hasNext()) {
			Skill skill = iterator.next();
			System.out.println(skill.toString());
		}
	}

	public void displayProfessional(Professional professional) {
		System.out.println(professional.toString());
		this.showAllFriends(professional.getFriends());
		this.showAllProjects(professional.getProjects());
		this.showAllEducations(professional.getEducation());
		this.showAllGroups(professional.getGroups());
		this.showAllCertifications(professional.getCertifications());
		this.showAllOrganizations(professional.getOrganizations());
		this.showAllJobCompany(professional.getPast_companies());
		this.showCurrentJobCompany(professional.getCurrent_companies());
		this.showAllRecommended_visitor(professional.getRecommended_visitors());
		this.showAllStrings(professional.getLanguages());
		this.showAllSkills(professional.getSkillsAll());

	}

	public void showAllStrings(List<String> list){
		Iterator<String> iterator=list.iterator();
		while (iterator.hasNext()){
			String string=iterator.next();
			System.out.println(string);
		}	
	}
	
	public List<Skill> getSkillsAll() {
		return skillsAll;
	}

	public void setSkillsAll(List<Skill> skillsAll) {
		this.skillsAll = skillsAll;
	}

}
