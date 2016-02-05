package com.websemproject.linkedin.sparql;

import java.util.List;

import com.websemproject.linkedin.model.Professional;

public class ProfessionalDetails {

	// Test
	public static void main(String[] args) {
		ProfessionalDetails professionalDetails = new ProfessionalDetails();
		Professional professional = new Professional();
		professional.setName("Mounir Guizani");
		professionalDetails.setProfessional(professional);
		ManagerSparql managerSparql = new ManagerSparql();
		managerSparql.initiate(professionalDetails);

	}

	private Professional professional;
	private List<String> hasSecondDegreeFriend;
	private List<String> hasThirdDegreeFriend;
	private List<String> workedInSameCompany;
	private List<String> isColleagueOf;
	private List<String> isFluentIn;
	private List<String> hasBasicCommunicationSkillsIn;
	private List<String> isExpertIn;
	private List<String> isStillStudentAt;
	private List<String> isGraduated;
	private List<String> WentSameUniversityAs;

	public ProfessionalDetails() {
		super();
		// TODO Auto-generated constructor stub

	}

	public ProfessionalDetails(Professional professional, List<String> hasSecondDegreeFriend,
			List<String> hasThirdDegreeFriend, List<String> workedInSameCompany, List<String> isColleagueOf,
			List<String> isFluentIn, List<String> hasBasicCommunicationSkillsIn, List<String> isExpertIn,
			List<String> isStillStudentAt, List<String> isGraduated, List<String> wentSameUniversityAs) {
		super();
		this.professional = professional;
		this.hasSecondDegreeFriend = hasSecondDegreeFriend;
		this.hasThirdDegreeFriend = hasThirdDegreeFriend;
		this.workedInSameCompany = workedInSameCompany;
		this.isColleagueOf = isColleagueOf;
		this.isFluentIn = isFluentIn;
		this.hasBasicCommunicationSkillsIn = hasBasicCommunicationSkillsIn;
		this.isExpertIn = isExpertIn;
		this.isStillStudentAt = isStillStudentAt;
		this.isGraduated = isGraduated;
		WentSameUniversityAs = wentSameUniversityAs;
	}

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	public List<String> getHasSecondDegreeFriend() {
		return hasSecondDegreeFriend;
	}

	public void setHasSecondDegreeFriend(List<String> hasSecondDegreeFriend) {
		this.hasSecondDegreeFriend = hasSecondDegreeFriend;
	}

	public List<String> getHasThirdDegreeFriend() {
		return hasThirdDegreeFriend;
	}

	public void setHasThirdDegreeFriend(List<String> hasThirdDegreeFriend) {
		this.hasThirdDegreeFriend = hasThirdDegreeFriend;
	}

	public List<String> getWorkedInSameCompany() {
		return workedInSameCompany;
	}

	public void setWorkedInSameCompany(List<String> workedInSameCompany) {
		this.workedInSameCompany = workedInSameCompany;
	}

	public List<String> getIsColleagueOf() {
		return isColleagueOf;
	}

	public void setIsColleagueOf(List<String> isColleagueOf) {
		this.isColleagueOf = isColleagueOf;
	}

	public List<String> getIsFluentIn() {
		return isFluentIn;
	}

	public void setIsFluentIn(List<String> isFluentIn) {
		this.isFluentIn = isFluentIn;
	}

	public List<String> getHasBasicCommunicationSkillsIn() {
		return hasBasicCommunicationSkillsIn;
	}

	public void setHasBasicCommunicationSkillsIn(List<String> hasBasicCommunicationSkillsIn) {
		this.hasBasicCommunicationSkillsIn = hasBasicCommunicationSkillsIn;
	}

	public List<String> getIsExpertIn() {
		return isExpertIn;
	}

	public void setIsExpertIn(List<String> isExpertIn) {
		this.isExpertIn = isExpertIn;
	}

	public List<String> getIsStillStudentAt() {
		return isStillStudentAt;
	}

	public void setIsStillStudentAt(List<String> isStillStudentAt) {
		this.isStillStudentAt = isStillStudentAt;
	}

	public List<String> getIsGraduated() {
		return isGraduated;
	}

	public void setIsGraduated(List<String> isGraduated) {
		this.isGraduated = isGraduated;
	}

	public List<String> getWentSameUniversityAs() {
		return WentSameUniversityAs;
	}

	public void setWentSameUniversityAs(List<String> wentSameUniversityAs) {
		WentSameUniversityAs = wentSameUniversityAs;
	}

}
