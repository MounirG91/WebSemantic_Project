package com.websemproject.linkedin.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;

import com.websemproject.linkedin.model.Certification;
import com.websemproject.linkedin.model.Education;
import com.websemproject.linkedin.model.Friend;
import com.websemproject.linkedin.model.Group;
import com.websemproject.linkedin.model.JobCompany;
import com.websemproject.linkedin.model.Organization;
import com.websemproject.linkedin.model.Professional;
import com.websemproject.linkedin.model.Project;
import com.websemproject.linkedin.model.RecommandedVisitor;
import com.websemproject.linkedin.model.Skill;
import com.websemproject.linkedin.model.University;

public class ParserXML {

	public Professional fromRdfFileToProfessional(String fileLocation, String profileName) throws NullPointerException {

		Professional professional = new Professional();

		Model model = FileManager.get().loadModel(fileLocation+"\\"+profileName+".rdf");
		Model modelSkills = FileManager.get().loadModel(fileLocation + "\\skills.rdf");
		Model modelCertifications = FileManager.get().loadModel(fileLocation + "\\certifications.rdf");
		Model modelUniversities = FileManager.get().loadModel(fileLocation + "\\universities.rdf");

		String ns = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + profileName;
		String lp = "http://linkedin_project.com/profile.rdfs#";

		Resource resourceProfessional = model.getResource(ns);

		Property name = model.getProperty(lp + "name");
		Property lastName = model.getProperty(lp + "lastName");
		Property firstName = model.getProperty(lp + "firstName");
		Property title = model.getProperty(lp + "title");
		Property linkedinUrl = model.getProperty(lp + "linkedinUrl");
		Property summary = model.getProperty(lp + "summary");
		Property location = model.getProperty(lp + "location");
		Property numberOfConnections = model.getProperty(lp + "numberOfConnections");
		Property industry = model.getProperty(lp + "industry");
		Property picture = model.getProperty(lp + "picture");
		Property country = model.getProperty(lp + "country");
		Property company = model.getProperty(lp + "company");
		Property hasLink = model.getProperty(lp + "hasLink");
		Property hasName = model.getProperty(lp + "hasName");
		Property hasTitle = model.getProperty(lp + "hasTitle");
		Property description = model.getProperty(lp + "description");
		Property startDate = model.getProperty(lp + "startDate");
		Property endDate = model.getProperty(lp + "endDate");
		Property duration = model.getProperty(lp + "duration");
		Property hasHeadQuarters = model.getProperty(lp + "hasHeadQuarters");
		Property hasEffective = model.getProperty(lp + "hasEffective");
		Property hasType = model.getProperty(lp + "hasType");
		Property hasWebsite = model.getProperty(lp + "hasWebsite");
		Property hasAdress = model.getProperty(lp + "hasAdress");
		Property lineOfBusiness = model.getProperty(lp + "lineOfBusiness");
		Property foundedIn = model.getProperty(lp + "foundedIn");
		Property firstAppeared = modelSkills.getProperty(lp +"firstAppeared");
		Property hasParadigm = modelSkills.getProperty(lp +"hasParadigm");
		Property lastVersion = modelSkills.getProperty(lp +"lastVersion");
		Property designedBy = modelSkills.getProperty(lp +"designedBy");
		Property hasDeveloper = modelSkills.getProperty(lp +"hasDeveloper");
		Property hasScore = modelSkills.getProperty(lp +"hasScore");
		Property relatedSkill = modelCertifications.getProperty(lp +"relatedSkill");
		Property createdBy = modelCertifications.getProperty(lp +"createdBy");
		Property administredBy = modelCertifications.getProperty(lp +"administeredBy");
		Property hasMaximumScore = modelCertifications.getProperty(lp +"hasMaximumScore");
		Property hasDirector = modelUniversities.getProperty(lp +"hasDirector");
		Property hasNumberOfStudents = modelUniversities.getProperty(lp +"hasNumberOfStudents");
		Property hasNumberOfTeachers = modelUniversities.getProperty(lp +"hasNumberOfTeachers");
		Property hasLanguageRegime = modelUniversities.getProperty(lp +"hasLanguageRegime");
		Property hasAdressUniversity = modelUniversities.getProperty(lp +"hasAdress");
		Property hasNameUniversity = modelUniversities.getProperty(lp +"hasName");
		Property foundedInUniversity = modelUniversities.getProperty(lp +"foundedIn");
		Property hasTypeUniversity = modelUniversities.getProperty(lp +"hasType");
		Property hasWebsiteUniversity = modelUniversities.getProperty(lp +"hasWebsite");
		Property hasWebsiteSkill = modelSkills.getProperty(lp + "hasWebsite");
		Property hasLicenseSkill=modelSkills.getProperty(lp + "hasLicense");

		if (resourceProfessional.getProperty(name)!=null)
		professional.setName(resourceProfessional.getProperty(name).getObject().toString());
		if (resourceProfessional.getProperty(lastName)!=null)
		professional.setLast_name(resourceProfessional.getProperty(lastName).getObject().toString());
		if (resourceProfessional.getProperty(firstName)!=null)
		professional.setFirst_name(resourceProfessional.getProperty(firstName).getObject().toString());
		if (resourceProfessional.getProperty(title)!=null)
		professional.setTitle(resourceProfessional.getProperty(title).getObject().toString());
		if (resourceProfessional.getProperty(linkedinUrl)!=null)
		professional.setLinkedin_url(resourceProfessional.getProperty(linkedinUrl).getObject().toString());
		if (resourceProfessional.getProperty(summary)!=null)
		professional.setSummary(resourceProfessional.getProperty(summary).getObject().toString());
		if (resourceProfessional.getProperty(numberOfConnections)!=null)
		professional
				.setNumber_of_connections(resourceProfessional.getProperty(numberOfConnections).getObject().toString());
		if (resourceProfessional.getProperty(industry)!=null)
		professional.setIndustry(resourceProfessional.getProperty(industry).getObject().toString());
		if (resourceProfessional.getProperty(picture)!=null)
		professional.setPicture(resourceProfessional.getProperty(picture).getObject().toString());
		if (resourceProfessional.getProperty(country)!=null)
		professional.setCountry(resourceProfessional.getProperty(country).getObject().toString());
		if (resourceProfessional.getProperty(picture)!=null)
		professional.setPicture(resourceProfessional.getProperty(picture).getObject().toString());
		if (resourceProfessional.getProperty(location)!=null)
		professional.setLocation(resourceProfessional.getProperty(location).getObject().toString());

		List<String> skills = new ArrayList<String>();
		List<String> languages = new ArrayList<String>();
		List<String> websites = new ArrayList<String>();
		List<String> associates = new ArrayList<String>();
		List<JobCompany> past_companies = new ArrayList<JobCompany>();
		List<JobCompany> current_companies = new ArrayList<JobCompany>();
		List<Organization> organizations = new ArrayList<Organization>();
		List<Friend> friends = new ArrayList<Friend>();
		List<RecommandedVisitor> recommandedVisitors = new ArrayList<RecommandedVisitor>();
		List<Group> groups = new ArrayList<Group>();
		List<Certification> certifications = new ArrayList<Certification>();
		List<Education> educations = new ArrayList<Education>();
		List<Project> projects = new ArrayList<Project>();
		List<Skill> skillsAll = new ArrayList<Skill>();

		for (StmtIterator i = resourceProfessional.listProperties(); i.hasNext();) {

			Statement s = i.next();
			System.out.println("has property " + s.getPredicate() + " with value " + s.getObject());

			if ((lp + "hasSkill").equals(s.getPredicate().toString())) {
				int positionOfDiez = s.getObject().toString().indexOf("#");
				String skill = s.getObject().toString().substring(positionOfDiez + 1,
						(s.getObject().toString().length()));
				skills.add(skill);
				Resource resourceSkill = modelSkills
						.getResource("http://linkedin_project.com/profile.rdfs-instances/Skill/#" + skill);
				String firstAppearedSkill = null;
				String paradigmSkill = null;
				String lastVersionSkill = null;
				String designedBySkill = null;
				String developerSkill = null;
				String licenceSkill = null;
				String websiteSkill = null;
				if (resourceSkill.getProperty(firstAppeared) != null) {
					firstAppearedSkill = resourceSkill.getProperty(firstAppeared).getObject().toString();
					paradigmSkill = resourceSkill.getProperty(hasParadigm).getObject().toString();
					lastVersionSkill = resourceSkill.getProperty(lastVersion).getObject().toString();
					designedBySkill = resourceSkill.getProperty(designedBy).getObject().toString();
					developerSkill = resourceSkill.getProperty(hasDeveloper).getObject().toString();
					if (resourceSkill.getProperty(hasLicenseSkill) != null)
					licenceSkill = resourceSkill.getProperty(hasLicenseSkill).getObject().toString();
					websiteSkill = resourceSkill.getProperty(hasWebsiteSkill).getObject().toString();
				}
				skillsAll.add(new Skill(skill, firstAppearedSkill, paradigmSkill, lastVersionSkill, designedBySkill,
						developerSkill, licenceSkill, websiteSkill));
			}

			if ((lp + "hasCertification").equals(s.getPredicate().toString())) {
				Resource resourceCertification = model.getResource(s.getObject().toString());
				String titleCertification=null;
				if (resourceCertification.getProperty(hasTitle)!=null)
				titleCertification = resourceCertification.getProperty(hasTitle).getObject().toString();
				String scoreCertification=null;
				if (resourceCertification.getProperty(hasScore)!=null)
				scoreCertification= resourceCertification.getProperty(hasScore).getObject().toString();
				Resource resourceCertificationInfoBox = modelCertifications
						.getResource("http://linkedin_project.com/profile.rdfs-instances/certificationInfoBox/#"
								+ titleCertification);
				String relatedSkillCertification = null;
				String createdByCertification = null;
				String administredByCertification = null;
				String maximumScoreCertification = null;
				String webSiteCertification = null;
				if (resourceCertificationInfoBox.getProperty(hasName) != null) {
					relatedSkillCertification = resourceCertificationInfoBox.getProperty(relatedSkill).getObject().toString();
					createdByCertification = resourceCertificationInfoBox.getProperty(createdBy).getObject().toString();
					if (resourceCertificationInfoBox.getProperty(administredBy)!=null)
					administredByCertification = resourceCertificationInfoBox.getProperty(administredBy).getObject()
							.toString();
					maximumScoreCertification = resourceCertificationInfoBox.getProperty(hasMaximumScore).getObject()
							.toString();
					webSiteCertification = resourceCertificationInfoBox.getProperty(hasWebsite).getObject().toString();
				}
				certifications.add(new Certification(titleCertification, scoreCertification, relatedSkillCertification,
						createdByCertification, administredByCertification, maximumScoreCertification,
						webSiteCertification));
			}

			if ((lp + "hasEducation").equals(s.getPredicate().toString())) {
				Resource resourceEducation = model.getResource(s.getObject().toString());
				String descriptionEducation = null;
				if (resourceEducation .getProperty(description) != null)
					descriptionEducation = resourceEducation .getProperty(description).getObject().toString();
				String titleEducation = null;
				if (resourceEducation .getProperty(hasTitle) != null)
					titleEducation = resourceEducation .getProperty(hasTitle).getObject().toString();
				String startDateEducation = null;
				if (resourceEducation .getProperty(startDate) != null)
					startDateEducation = resourceEducation .getProperty(startDate).getObject().toString();
				String endDateEducation = null;
				if (resourceEducation .getProperty(endDate) != null)
					endDateEducation = resourceEducation .getProperty(endDate).getObject().toString();
				String durationEducation = null;
				if (resourceEducation .getProperty(duration) != null)
					durationEducation = resourceEducation .getProperty(duration).getObject().toString();
				Resource resourceEducationDetails = modelUniversities
						.getResource("http://linkedin_project.com/profile.rdfs-instances/University/#" + titleEducation);
				String nameUniv = null;
				String foundedInUniv = null;
				String typeUniv = null;
				String websiteUniv = null;
				String directorUniv = null;
				String numberOfStudentsUniv = null;
				String numberOfTeachersUniv = null;
				String hasLanguageRegimeUniv = null;
				String hasAdressUniv = null;
				if (resourceEducationDetails.getProperty(hasNameUniversity) != null) {
					nameUniv = resourceEducationDetails.getProperty(hasNameUniversity).getObject().toString();
					foundedInUniv = resourceEducationDetails.getProperty(foundedInUniversity).getObject().toString();
					typeUniv = resourceEducationDetails.getProperty(hasTypeUniversity).getObject().toString();
					websiteUniv = resourceEducationDetails.getProperty(hasWebsiteUniversity).getObject().toString();
					directorUniv = resourceEducationDetails.getProperty(hasDirector).getObject().toString();
					numberOfStudentsUniv = resourceEducationDetails.getProperty(hasNumberOfStudents).getObject().toString();
					numberOfTeachersUniv = resourceEducationDetails.getProperty(hasNumberOfTeachers).getObject().toString();
					hasLanguageRegimeUniv = resourceEducationDetails.getProperty(hasLanguageRegime).getObject().toString();
					hasAdressUniv = resourceEducationDetails.getProperty(hasAdressUniversity).getObject().toString();

				}
				Education education = new Education(titleEducation, descriptionEducation, descriptionEducation,
						descriptionEducation, durationEducation, startDateEducation, endDateEducation);
				education.setUniversity(new University(nameUniv, foundedInUniv, typeUniv, websiteUniv, directorUniv,
						numberOfStudentsUniv, numberOfTeachersUniv, hasLanguageRegimeUniv, hasAdressUniv));
				educations.add(education);
			}

			if ((lp + "hasRecommandedVisitor").equals(s.getPredicate().toString())) {
				Resource resourceRecommandedVisitor = model.getResource(s.getObject().toString());
				String nameRecommandedVisitor = resourceRecommandedVisitor.getProperty(name).getObject().toString();
				String titleRecommandedVisitor=null;
				if (resourceRecommandedVisitor.getProperty(title)!=null)
				titleRecommandedVisitor = resourceRecommandedVisitor.getProperty(title).getObject().toString();
				String linkRecommandedVisitor = resourceRecommandedVisitor.getProperty(linkedinUrl).getObject()
						.toString();
				String companyRecommandedVisitor = null;
				if (resourceRecommandedVisitor.getProperty(company) != null) {
					int positionOfDiez = resourceRecommandedVisitor.getProperty(company).getObject().toString()
							.indexOf("#");
					companyRecommandedVisitor = resourceRecommandedVisitor.getProperty(company).getObject().toString()
							.substring((positionOfDiez + 1),
									resourceRecommandedVisitor.getProperty(company).getObject().toString().length());
				}
				RecommandedVisitor recommandedVisitor = new RecommandedVisitor(nameRecommandedVisitor,
						titleRecommandedVisitor, linkRecommandedVisitor, companyRecommandedVisitor);
				recommandedVisitors.add(recommandedVisitor);
			}

			if ((lp + "hasFriend").equals(s.getPredicate().toString())) {
				int positionOfDiez = s.getObject().toString().indexOf("#");
				String nameFriend = s.getObject().toString().substring(positionOfDiez + 1,
						(s.getObject().toString().length()));
				friends.add(new Friend(nameFriend));
			}

			if ((lp + "speacksLanguage").equals(s.getPredicate().toString())) {
				int positionOfDiez = s.getObject().toString().indexOf("#");
				String language = s.getObject().toString().substring(positionOfDiez + 1,
						(s.getObject().toString().length()));
				languages.add(language);
			}

			if ((lp + "websites").equals(s.getPredicate().toString())) {
				int positionOfDiez = s.getObject().toString().indexOf("#");
				String website = s.getObject().toString().substring(positionOfDiez + 1,
						(s.getObject().toString().length()));
				websites.add(website);
			}

			if ((lp + "belongToGroup").equals(s.getPredicate().toString())) {
				Resource resourceGroup = model.getResource(s.getObject().toString());
				String nameGroup = resourceGroup.getProperty(hasName).getObject().toString();
				String linkGroup = resourceGroup.getProperty(hasLink).getObject().toString();
				groups.add(new Group(nameGroup, linkGroup));
			}

			if ((lp + "joinOrganization").equals(s.getPredicate().toString())) {
				Resource resourceOrganization = model.getResource(s.getObject().toString());
				String nameOrganization = resourceOrganization.getProperty(hasName).getObject().toString();
				String linkOrganization = resourceOrganization.getProperty(hasLink).getObject().toString();
				organizations.add(new Organization(nameOrganization, linkOrganization));
			}

			if ((lp + "didProject").equals(s.getPredicate().toString())) {
				Resource resourceProject = model.getResource(s.getObject().toString());
				String titleProjet = resourceProject.getProperty(hasTitle).getObject().toString();
				String descriptionProject = resourceProject.getProperty(description).getObject().toString();
				String linkProject = null;
				if (resourceProject.getProperty(hasLink) != null)
					linkProject = resourceProject.getProperty(hasLink).getObject().toString();
				String startDateProject = null;
				if (resourceProject.getProperty(startDate) != null)
					startDateProject = resourceProject.getProperty(startDate).getObject().toString();
				String endDateProject = null;
				if (resourceProject.getProperty(endDate) != null)
					endDateProject = resourceProject.getProperty(endDate).getObject().toString();
				for (StmtIterator j = resourceProject.listProperties(); j.hasNext();) {
					Statement sa = j.next();
					if ((lp + "hasAssociates").equals(sa.getPredicate().toString())) {
						int positionOfDiez = sa.getObject().toString().indexOf("#");
						String associate = sa.getObject().toString().substring(positionOfDiez + 1,
								(sa.getObject().toString().length()));
						associates.add(associate);
					}
				}
				projects.add(new Project(titleProjet, linkProject, startDateProject, endDateProject, descriptionProject,
						null, associates));
			}

			if ((lp + "hadPosition").equals(s.getPredicate().toString())) {
				Resource resourcePosition = model.getResource(s.getObject().toString());
				String descriptionPosition=null;
				if (resourcePosition.getProperty(description)!=null)
				descriptionPosition= resourcePosition.getProperty(description).getObject().toString();
				String titlePosition = resourcePosition.getProperty(hasTitle).getObject().toString();
				String startDatePosition = null;
				if (resourcePosition.getProperty(startDate) != null)
					startDatePosition = resourcePosition.getProperty(startDate).getObject().toString();
				String durationPosition = null;
				if (resourcePosition.getProperty(endDate) != null)
					durationPosition = resourcePosition.getProperty(duration).getObject().toString();
				String headQuartersCompany = null;
				String effectiveCompany = null;
				String typeCompany = null;
				String adressCompany = null;
				String nameCompany = null;
				String lineOfBusinessCompany = null;
				String linkedinUrlCompany = null;
				String websiteCompany = null;
				String foundedInCompany = null;
				for (StmtIterator j = resourcePosition.listProperties(); j.hasNext();) {
					Statement sa = j.next();
					if ((lp + "tookPlaceIn").equals(sa.getPredicate().toString())) {
						Resource resourceCompany = model.getResource(sa.getObject().toString());
						if (resourceCompany.getProperty(hasHeadQuarters)!=null)
						headQuartersCompany = resourceCompany.getProperty(hasHeadQuarters).getObject().toString();
						if (resourceCompany.getProperty(hasEffective)!=null)
						effectiveCompany = resourceCompany.getProperty(hasEffective).getObject().toString();
						if (resourceCompany.getProperty(hasType)!=null)
						typeCompany = resourceCompany.getProperty(hasType).getObject().toString();
						if (resourceCompany.getProperty(hasAdress)!=null)
						adressCompany = resourceCompany.getProperty(hasAdress).getObject().toString();
						nameCompany = resourceCompany.getProperty(hasName).getObject().toString();
						if (resourceCompany.getProperty(lineOfBusiness)!=null)
						lineOfBusinessCompany = resourceCompany.getProperty(lineOfBusiness).getObject().toString();
						if (resourceCompany.getProperty(linkedinUrl)!=null)
						linkedinUrlCompany = resourceCompany.getProperty(linkedinUrl).getObject().toString();
						if (resourceCompany.getProperty(hasWebsite)!=null)
						websiteCompany = resourceCompany.getProperty(hasWebsite).getObject().toString();
						if (resourceCompany.getProperty(foundedIn)!=null)
						foundedInCompany = resourceCompany.getProperty(foundedIn).getObject().toString();
					}
				}
				past_companies.add(new JobCompany(titlePosition, nameCompany, descriptionPosition, durationPosition,
						startDatePosition, linkedinUrlCompany, null, websiteCompany, lineOfBusinessCompany, typeCompany,
						headQuartersCompany, effectiveCompany, foundedInCompany, adressCompany));
			}

			if ((lp + "hasPosition").equals(s.getPredicate().toString())) {
				Resource resourcePosition = model.getResource(s.getObject().toString());
				String descriptionPosition=null;
				if (resourcePosition.getProperty(description)!=null)
				descriptionPosition = resourcePosition.getProperty(description).getObject().toString();
				String titlePosition = resourcePosition.getProperty(hasTitle).getObject().toString();
				String startDatePosition = null;
				if (resourcePosition.getProperty(startDate) != null)
					startDatePosition = resourcePosition.getProperty(startDate).getObject().toString();
				String durationPosition = null;
				if (resourcePosition.getProperty(endDate) != null)
					durationPosition = resourcePosition.getProperty(duration).getObject().toString();
				String headQuartersCompany = null;
				String effectiveCompany = null;
				String typeCompany = null;
				String adressCompany = null;
				String nameCompany = null;
				String lineOfBusinessCompany = null;
				String linkedinUrlCompany = null;
				String websiteCompany = null;
				String foundedInCompany = null;
				for (StmtIterator j = resourcePosition.listProperties(); j.hasNext();) {
					Statement sa = j.next();
					if ((lp + "tookPlaceIn").equals(sa.getPredicate().toString())) {
						Resource resourceCompany = model.getResource(sa.getObject().toString());
						if (resourceCompany.getProperty(hasHeadQuarters) != null)
							headQuartersCompany = resourceCompany.getProperty(hasHeadQuarters).getObject().toString();
						if (resourceCompany.getProperty(hasEffective)!=null)
						effectiveCompany = resourceCompany.getProperty(hasEffective).getObject().toString();
						if (resourceCompany.getProperty(hasType)!=null)
						typeCompany = resourceCompany.getProperty(hasType).getObject().toString();
						if (resourceCompany.getProperty(hasAdress)!=null)
						adressCompany = resourceCompany.getProperty(hasAdress).getObject().toString();
						nameCompany = resourceCompany.getProperty(hasName).getObject().toString();
						if (resourceCompany.getProperty(lineOfBusiness)!=null)
						lineOfBusinessCompany = resourceCompany.getProperty(lineOfBusiness).getObject().toString();
						if (resourceCompany.getProperty(linkedinUrl)!=null)
						linkedinUrlCompany = resourceCompany.getProperty(linkedinUrl).getObject().toString();
						if (resourceCompany.getProperty(hasWebsite)!=null)
						websiteCompany = resourceCompany.getProperty(hasWebsite).getObject().toString();
						if (resourceCompany.getProperty(foundedIn) != null)
							foundedInCompany = resourceCompany.getProperty(foundedIn).getObject().toString();
					}
				}
				current_companies.add(new JobCompany(titlePosition, nameCompany, descriptionPosition, durationPosition,
						startDatePosition, linkedinUrlCompany, null, websiteCompany, lineOfBusinessCompany, typeCompany,
						headQuartersCompany, effectiveCompany, foundedInCompany, adressCompany));
			}

		}

		professional.setCertifications(certifications);
		professional.setWebsites(websites);
		professional.setCurrent_companies(current_companies);
		professional.setPast_companies(past_companies);
		professional.setGroups(groups);
		professional.setLanguages(languages);
		professional.setEducation(educations);
		professional.setOrganizations(organizations);
		professional.setRecommended_visitors(recommandedVisitors);
		professional.setFriends(friends);
		professional.setSkillsAll(skillsAll);
		professional.setProjects(projects);

		return professional;

	}

}
