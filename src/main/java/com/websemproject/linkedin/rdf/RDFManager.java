package com.websemproject.linkedin.rdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;

import com.websemproject.linkedin.model.Education;
import com.websemproject.linkedin.model.Friend;
import com.websemproject.linkedin.model.Group;
import com.websemproject.linkedin.model.JobCompany;
import com.websemproject.linkedin.model.Organization;
import com.websemproject.linkedin.model.Professional;
import com.websemproject.linkedin.model.Project;


public class RDFManager {


	static Model model = ModelFactory.createDefaultModel();
	
	static String mainUri = "http://linkedin_project.com/profile.rdfs";

	//préparer les classes
	static String classProfessional = mainUri + "#Professional";
	static String classProject = mainUri + "#Project";
	static String classEducation = mainUri + "#Education";
	static String classPost = mainUri + "#Post";
	static String classLanguage = mainUri + "#Language";
	static String classSkill = mainUri + "#Skill";
	static String classCertification = mainUri + "#Certification";
	static String classGroup = mainUri + "#Group";
	static String classOrganization = mainUri + "#Organization";
	static String classCompany = mainUri + "#Company";
	static String classUniversity = mainUri + "#University";
	static String classCountry = mainUri + "#Country";
	static String classLanguageCertification = mainUri + "#languageCertification";
	static String classITCertification = mainUri + "#ITCertification";
	static String classEngineer = mainUri + "#Engineer";
	static String classDevelopmentEngineer = mainUri + "#softwareEngineer";
	static String classRandDEngineer = mainUri + "#RandDEngineer";
	static String classSecurityEngineer = mainUri + "#securityEngineer";
	static String classTeacher = mainUri + "#Teacher";
	static String classPhD = mainUri + "#PhD";
	static String classTrainee = mainUri + "#Trainee";
	static String classPreparatoryCycle = mainUri + "#preparatoryCycle";
	static String classEngineeringStudies = mainUri + "#engineeringStudies";
	static String classMasterDegreeStudies = mainUri + "#masterDegreeStudies";
	static String classLicenceDegreeStudies = mainUri + "#licenceDegreeStudies";

	public void professionalToRDF(Professional professional) {
		
		//Prepare all properties
		String propertyNameUri = mainUri + "#name";
		String propertyFirstNameUri = mainUri + "#firstName";
		String propertyLastNameUri = mainUri + "#lastName";
		String propertyTitleUri = mainUri + "#title";
		String propertySummaryUri = mainUri + "#summary";
		String propertyLocationUri = mainUri + "#location";
		String propertyNumberOfConnectionsUri = mainUri + "#numberOfConnections";
		String propertyCountryUri = mainUri + "#country";
		String propertyIndustryUri = mainUri + "#industry";
		String propertyPictureUri = mainUri + "#picture";
		String propertyLinkedinURLUri = mainUri + "#linkedinUrl";

		String propertyHasSkillUri = mainUri + "#hasSkill";
		String propertyDidProjectUri = mainUri + "#didProject";
		String propertyBelongToGroupUri = mainUri + "#belongToGroup";
		String propertyHasEducationUri = mainUri + "#hasEducation";
		//String propertyHasCertificationUri = mainUri + "#hasCertification";
		String propertrySpeacksLanguageUri = mainUri + "#speacksLanguage";
		String propertyJoinOrganizationUri = mainUri + "#joinOrganization";
		String propertyHadPositionUri = mainUri + "#hadPosition";
		String propertyHasPositionUri = mainUri + "#hasPosition";
		String propertyHasFriendUri = mainUri + "#hasFriend";
		//String propertyHasRecommandedVisitorUri = mainUri + "#hasRecommandedVisitor";

		String propertyHasTitleUri = mainUri + "#hasTitle";

		String propertyHasNameUri = mainUri + "#hasName";
		String propertyStartDateUri = mainUri + "#startDate";
		String propertyEndDateUri = mainUri + "#endDate";
		String propertyDescriptionUri = mainUri + "#description";

		String propertyDoneInUniversityUri = mainUri + "#doneInUniversity";
		String propertyHasMajorUri = mainUri + "#hasMajor";
		String propertyHasDegreeUri = mainUri + "#hasDegree";

		String propertyTookPlaceInUri = mainUri + "#tookPlaceIn";
		String propertyDurationUri = mainUri + "#duration";

		String propertyHasWebsiteUri = mainUri + "#hasWebsite";

		String propertyHasLinkUri = mainUri + "#hasLink";

		String propertyHasAssociatesUri = mainUri + "#hasAssociates";

		//String propertryFoundedInUri = mainUri + "#foundedIn";
		String propertyHasTypeUri = mainUri + "#hasType";
		String propertyHasAdressUri = mainUri + "#hasAdress";

		String propertyLineOfBusineesUri = mainUri + "#lineOfBusiness";
		String propertyHasEffectiveUri = mainUri + "#hasEffective";
		String propertyHasFoundedUri = mainUri + "#foundedIn";
		String propertyHasHeadQuartersUri = mainUri + "#hasHeadQuarters";
/*
		String propertyHasDirectorUri = mainUri + "#hasDirector";
		String propertyHasNumberOfStudentsUri = mainUri + "#hasNumberOfStudents";
		String propertyHasNumberOfTeachersUri = mainUri + "#hasNumberOfTeachers";
		String propertyHasLanguageRegimeUri = mainUri + "#hasLanguageRegime";

		String propertyFirstAppearedUri = mainUri + "#firstAppeared";
		String propertyHasParadigmUri = mainUri + "#hasParadigm";
		String propertyLastVersionUri = mainUri + "#hasLastVersion";
		String propertyDesignedByUri = mainUri + "#designedBy";
		String propertyHasDeveloperUri = mainUri + "#hasDeveloper";
		String propertyHasLicenceUri = mainUri + "#hasLicence";

		String propertyRelatedSkillUri = mainUri + "#relaredSkill";
		String propertyCreatedByUri = mainUri + "#createdBy";
		String propertyAdministerdByUri = mainUri + "#administredBy";
		String propertyHasMaximumScoreUri = mainUri + "#hasMaximumScore";
		String propertyHasScoreUri = mainUri + "#hasScore";*/
	
		model.setNsPrefix("lp", mainUri+"#");

		//Declare all properties
		Property name = model.createProperty(propertyNameUri);
		Property first_name = model.createProperty(propertyFirstNameUri);
		Property last_name = model.createProperty(propertyLastNameUri);
		Property title = model.createProperty(propertyTitleUri);
		Property summary = model.createProperty(propertySummaryUri);
		Property location = model.createProperty(propertyLocationUri);
		Property number_of_connections = model.createProperty(propertyNumberOfConnectionsUri);
		Property country = model.createProperty(propertyCountryUri);
		Property industry = model.createProperty(propertyIndustryUri);
		Property picture = model.createProperty(propertyPictureUri);
		Property linkedin_url = model.createProperty(propertyLinkedinURLUri);
		Property hasSkill = model.createProperty(propertyHasSkillUri);
		Property didProject = model.createProperty(propertyDidProjectUri);
		Property belongToGroup = model.createProperty(propertyBelongToGroupUri);
		Property hasEducation = model.createProperty(propertyHasEducationUri);
		//Property hasCertification = model.createProperty(propertyHasCertificationUri);
		Property speacksLanguage = model.createProperty(propertrySpeacksLanguageUri);
		Property joinOrganization = model.createProperty(propertyJoinOrganizationUri);
		Property hadPosition = model.createProperty(propertyHadPositionUri);
		Property hasPosition = model.createProperty(propertyHasPositionUri);
		Property hasFriend = model.createProperty(propertyHasFriendUri);
		//Property hasRecommandedVisitor = model.createProperty(propertyHasRecommandedVisitorUri);
		Property hasTitle = model.createProperty(propertyHasTitleUri);
		Property hasName = model.createProperty(propertyHasNameUri);
		Property startDate = model.createProperty(propertyStartDateUri);
		Property endDate = model.createProperty(propertyEndDateUri);
		Property duration = model.createProperty(propertyDurationUri);
		Property description = model.createProperty(propertyDescriptionUri);
		Property doneInUniversity = model.createProperty(propertyDoneInUniversityUri);
		Property hasMajor = model.createProperty(propertyHasMajorUri);
		Property hasDegree = model.createProperty(propertyHasDegreeUri);
		Property tookPlaceIn = model.createProperty(propertyTookPlaceInUri);
		Property hasLink = model.createProperty(propertyHasLinkUri);
		Property hasAssociates = model.createProperty(propertyHasAssociatesUri);
		Property hasWebsite = model.createProperty(propertyHasWebsiteUri);
		//Property foundedIn = model.createProperty(propertryFoundedInUri);
		Property hasType = model.createProperty(propertyHasTypeUri);
		Property hasAdress = model.createProperty(propertyHasAdressUri);
		Property lineOfBusiness = model.createProperty(propertyLineOfBusineesUri);
		Property hasEffective = model.createProperty(propertyHasEffectiveUri);
		Property hasFounded = model.createProperty(propertyHasFoundedUri);
		Property hasHeadquarters = model.createProperty(propertyHasHeadQuartersUri);
		/*Property hasDirector = model.createProperty(propertyHasDirectorUri);
		Property hasNumberOfStudents = model.createProperty(propertyHasNumberOfStudentsUri);
		Property hasNumberOfTeachers = model.createProperty(propertyHasNumberOfTeachersUri);
		Property hasLanguageRegime = model.createProperty(propertyHasLanguageRegimeUri);
		Property firstAppeared = model.createProperty(propertyFirstAppearedUri);
		Property hasParadigm = model.createProperty(propertyHasParadigmUri);
		Property lastVersion = model.createProperty(propertyLastVersionUri);
		Property designedBy = model.createProperty(propertyDesignedByUri);
		Property hasDeveloper = model.createProperty(propertyHasDeveloperUri);
		Property hasLicence = model.createProperty(propertyHasLicenceUri);
		Property relatedSkill = model.createProperty(propertyRelatedSkillUri);
		Property createdBy = model.createProperty(propertyCreatedByUri);
		Property administredBy = model.createProperty(propertyAdministerdByUri);
		Property hasMaximumScore = model.createProperty(propertyHasMaximumScoreUri);
		Property hasScore = model.createProperty(propertyHasScoreUri);*/

	String mainUriInstances = "http://linkedin_project.com/profile.rdfs-instances/";

		//URI
		String professionalUri = mainUriInstances + "Professional/";
		String educationUri = mainUriInstances + "Education/";
		String postUri = mainUriInstances + "Post/";
		String languageUri = mainUriInstances + "Language/";
		String skillUri = mainUriInstances + "Skill/";
		String projectUri = mainUriInstances + "Project/";
		//String certificationUri = mainUriInstances + "Certification/";
		String groupUri = mainUriInstances + "Group/";
		String organizationUri = mainUriInstances + "Organization/";
		String companyUri = mainUriInstances + "Company/";
		String universityUri = mainUriInstances + "University/";
		String countryUri = mainUriInstances + "Country/";
		/*String languageCertificationUri = mainUriInstances + "languageCertification/";
		String ITCertificationUri = mainUriInstances + "ITCertification/";
		String engineerUri = mainUriInstances + "Engineer/";
		String developmentEngineerUri = mainUriInstances + "softwareEngineer/";
		String RandDEngineerUri = mainUriInstances + "RandDEngineer/";
		String decurityEngineerUri = mainUriInstances + "securityEngineer/";
		String teacherUri = mainUriInstances + "Teacher/";
		String PhDStudentUri = mainUriInstances + "PhDStudent/";
		String traineeUri = mainUriInstances + "Trainee/";
		String preparatoryCycleUri = mainUriInstances + "preparatoryCycle/";
		String engineeringStudiesUri = mainUriInstances + "engineeringStudies/";
		String masterDegreeStudiesUri = mainUriInstances + "masterDegreeStudies/";*/

		
		
		Resource professionalProfile = model
				.createResource(professionalUri + "#"+ professional.getName());
		professionalProfile.addProperty(RDF.type, classProfessional);

		model.add(professionalProfile, name, professional.getName());
		model.add(professionalProfile, first_name, professional.getFirst_name());
		model.add(professionalProfile, last_name, professional.getLast_name());
		model.add(professionalProfile, title, professional.getTitle());
		model.add(professionalProfile, location, professional.getLocation());
		model.add(professionalProfile, number_of_connections, professional.getNumber_of_connections());
		model.add(professionalProfile, industry, professional.getIndustry());
		model.add(professionalProfile, picture, professional.getPicture());
		model.add(professionalProfile, linkedin_url, professional.getLinkedin_url());
		if (professional.getSummary() != null)
			model.add(professionalProfile, summary, professional.getSummary());

		Resource countryProfile = model
				.createResource(countryUri + "#"+ professional.getCountry());
		//model.add(countryProfile, RDF.type, classCountry);
		model.add(professionalProfile, country, countryProfile);

		Iterator<String> languages = professional.getLanguages().iterator();
		while (languages.hasNext()) {
			String language = languages.next();
			Resource languageProfile = model
					.createResource(languageUri +"#"+ language);
			model.add(professionalProfile, speacksLanguage, languageProfile);
		}

		Iterator<String> skillsString = professional.getSkills().iterator();
		while (skillsString.hasNext()) {
			String skillString = skillsString.next();
			Resource skillProfile = model
					.createResource(skillUri + "#"+ skillString);
			model.add(professionalProfile, hasSkill, skillProfile);
		}

	
		Iterator<Education> educations = professional.getEducation().iterator();
		while (educations.hasNext()) {
			Education education = educations.next();
			Resource educationProfile = model
					.createResource(educationUri + professional.getName() + "/#" + education.getName());
			model.add(professionalProfile, hasEducation, educationProfile);
			
			if (education.getName() != null)
				model.add(educationProfile, hasTitle, education.getName());
			if (education.getStart_date() != null)
				model.add(educationProfile, startDate, education.getStart_date());
			if (education.getEnd_date() != null)
				model.add(educationProfile, endDate, education.getEnd_date());
			if (education.getPeriod() != null)
				model.add(educationProfile, duration, education.getPeriod());
			if (education.getDescription() != null)
				model.add(educationProfile, description, education.getDescription());
			if (education.getMajor() != null)
				model.add(educationProfile, hasMajor, education.getMajor());
			if (education.getDegree() != null)
				model.add(educationProfile, hasDegree, education.getDegree());
			
			if (education.getName() != null){
				Resource universityProfile = model
				.createResource(universityUri + "#"+ education.getName());
		       model.add(educationProfile, doneInUniversity, universityProfile);
			}
			
			if (education.getName() != null){
		
		 if (education.getName().toLowerCase().contains("master") ||
		        		   education.getDescription().toLowerCase().contains("master")   )
		    
			 model.add(educationProfile, RDF.type, classMasterDegreeStudies);
		     
		 else if (education.getName().toLowerCase().contains("ecole") ||
        		   education.getDescription().toLowerCase().contains("ecole")  ||
        		   education.getName().toLowerCase().contains("ingenieur")  ||
        		   education.getDescription().toLowerCase().contains("ingenieur") ||
        		   education.getName().toLowerCase().contains("engineer")  ||
        		   education.getDescription().toLowerCase().contains("engineer"))

     		model.add(educationProfile, RDF.type, classEngineeringStudies);
          
		  else if (education.getName().toLowerCase().contains("preparatoire") ||
        		   education.getDescription().toLowerCase().contains("preparatoire")  ||
        		   education.getName().toLowerCase().contains("preparatory")  ||
        		   education.getDescription().toLowerCase().contains("preparatory") )

			  model.add(educationProfile, RDF.type, classPreparatoryCycle);
        	  

		  else if (education.getName().toLowerCase().contains("licence") ||
        		   education.getDescription().toLowerCase().contains("licence")   )
           
          		model.add(educationProfile, RDF.type, classLicenceDegreeStudies);

		  else if (education.getName().toLowerCase().contains("phd") ||
       		   education.getDescription().toLowerCase().contains("phd")  ||
       		   education.getName().toLowerCase().contains("doctorat")  ||
       		   education.getDescription().toLowerCase().contains("doctorat")||
       		   education.getName().toLowerCase().contains("doctorant")  ||
       		   education.getDescription().toLowerCase().contains("doctorant") )

			  model.add(educationProfile, RDF.type, classPhD);

		 
		  else model.add(educationProfile, RDF.type, classEducation);

		}

		}

		
		Iterator<Group> groups = professional.getGroups().iterator();
		while (groups.hasNext()) {
			Group group = groups.next();
			Resource groupProfile = model
					.createResource(groupUri +"#"+ group.getName());
			model.add(professionalProfile, belongToGroup, groupProfile);
			if (group.getName() != null)
				model.add(groupProfile, hasName, group.getName());
			if (group.getLink() != null)
				model.add(groupProfile, hasLink, group.getLink());
		}
		
		
		Iterator<Organization> organizations = professional.getOrganizations().iterator();
		while (organizations.hasNext()) {
			Organization org = organizations.next();
			Resource orgpProfile = model
					.createResource(organizationUri +"#"+ org.getName());
			model.add(professionalProfile, joinOrganization, orgpProfile);
			if (org.getName() != null)
				model.add(orgpProfile, hasName, org.getName());
			if (org.getLink() != null)
				model.add(orgpProfile, hasLink, org.getLink());
		}
		
		Iterator<Project> projects = professional.getProjects().iterator();
		while (projects.hasNext()) {
			Project project = projects.next();
			Resource projectProfile = model
					.createResource(projectUri + professional.getName() + "/#" + project.getTitle());
			model.add(professionalProfile, didProject, projectProfile);
			if (project.getTitle() != null)
				model.add(projectProfile, hasTitle, project.getTitle());
			if (project.getStart_date() != null)
				model.add(projectProfile, startDate, project.getStart_date());
			if (project.getEnd_date() != null)
				model.add(projectProfile, endDate, project.getEnd_date());
			if (project.getDescription() != null)
				model.add(projectProfile, description, project.getDescription());
			if (project.getLink() != null)
				model.add(projectProfile, hasLink, project.getLink());
			if (project.getAssociates() != null) {
				Iterator<String> associates = project.getAssociates().iterator();
				while (associates.hasNext()) {
					String associate = associates.next();
					Resource associateProfile = model.createResource(professionalUri + "#"+associate);
					model.add(projectProfile, hasAssociates, associateProfile);
			}

		}}


		if (professional.getCurrent_companies().size() ==0 &&professional.getPast_companies().size() !=0 )
		{
			List <JobCompany> list = new ArrayList<JobCompany>();
			list.add(professional.getPast_companies().get(0));
			professional.getPast_companies().remove(0);
			professional.setCurrent_companies(list);
		}
		Iterator<JobCompany> current_companies = professional.getCurrent_companies().iterator();
		while (current_companies.hasNext()) {
			JobCompany current_post = current_companies.next();
			Resource current_postProfile = model.createResource(
					postUri + professional.getName() + "/#" + current_post.getTitle());
			model.add(professionalProfile, hasPosition, current_postProfile);

			getPostType(current_post, current_postProfile);
			
			if (current_post.getTitle() != null)
				model.add(current_postProfile, hasTitle, current_post.getTitle());
			if (current_post.getStart_date() != null)
				model.add(current_postProfile, startDate, current_post.getStart_date());
			if (current_post.getDuration() != null)
				model.add(current_postProfile, duration, current_post.getDuration());
			if (current_post.getDescription() != null)
				model.add(current_postProfile, description, current_post.getDescription());
			if (current_post.getCompany() != null){
				Resource currentCompany = model.createResource(companyUri +"#"+ current_post.getCompany());

				model.add(currentCompany, hasName, current_post.getCompany());

				if (current_post.getLinkedin_company_url() != null)
					model.add(currentCompany, linkedin_url, current_post.getLinkedin_company_url());
				if (current_post.getFounded() != null)
					model.add(currentCompany, hasFounded, current_post.getFounded());
				if (current_post.getIndustry() != null)
					model.add(currentCompany, lineOfBusiness, current_post.getIndustry());
				if (current_post.getAddress() != null)
					model.add(currentCompany, hasAdress, current_post.getAddress());
				if (current_post.getWebsite() != null)
					model.add(currentCompany, hasWebsite, current_post.getWebsite());
				if (current_post.getType() != null)
					model.add(currentCompany, hasType, current_post.getType());
				if (current_post.getCompany_size() != null)
					model.add(currentCompany, hasEffective, current_post.getCompany_size());

				model.add(current_postProfile, tookPlaceIn, currentCompany);

			}
		}


		Iterator<JobCompany> past_position = professional.getPast_companies().iterator();
	
		while (past_position.hasNext()) {
			JobCompany past_post = past_position.next();
			Resource past_postProfile = model.createResource(
					postUri + professional.getName() + "/#" + past_post.getTitle());
		
			model.add(professionalProfile, hadPosition, past_postProfile);
			
			getPostType(past_post, past_postProfile);
			
			if (past_post.getTitle() != null)
				model.add(past_postProfile, hasTitle, past_post.getTitle());
			if (past_post.getStart_date() != null)
				model.add(past_postProfile, startDate, past_post.getStart_date());
			if (past_post.getDuration() != null)
				model.add(past_postProfile, duration, past_post.getDuration());
			if (past_post.getDescription() != null)
				model.add(past_postProfile, description, past_post.getDescription());
			if (past_post.getCompany() != null){
				Resource currentCompany = model.createResource(companyUri +"#"+ past_post.getCompany());

				model.add(currentCompany, hasName, past_post.getCompany());

				if (past_post.getLinkedin_company_url() != null)
					model.add(currentCompany, linkedin_url, past_post.getLinkedin_company_url());
				if (past_post.getFounded() != null)
					model.add(currentCompany, hasFounded, past_post.getFounded());
				if (past_post.getIndustry() != null)
					model.add(currentCompany, lineOfBusiness, past_post.getIndustry());
				if (past_post.getAddress() != null)
					model.add(currentCompany, hasAdress, past_post.getAddress());
				if (past_post.getWebsite() != null)
					model.add(currentCompany, hasWebsite, past_post.getWebsite());
				if (past_post.getType() != null)
					model.add(currentCompany, hasType, past_post.getType());
				if (past_post.getCompany_size() != null)
					model.add(currentCompany, hasEffective, past_post.getCompany_size());
				if (past_post.getHeadquarters() != null)
					model.add(currentCompany, hasHeadquarters, past_post.getHeadquarters());
				
				model.add(past_postProfile, tookPlaceIn, currentCompany);

			}
		}

		 
		for (int i=0; i<professional.getWebsites().size(); i++)
		{

			model.add(professionalProfile, hasWebsite, professional.getWebsites().get(i));
			
		}


		if (professional.getFriends() != null) {
			Iterator<Friend> friends = professional.getFriends().iterator();
			while (friends.hasNext()) {
				Friend friend = friends.next();
				Resource friendProfile = model
						.createResource(professionalUri +"#"+ friend.getName());
				model.add(professionalProfile, hasFriend, friendProfile);
		}
	}
		
//		Iterator<Certification> certifications = professional.getCertifications().iterator();
//		while (certifications.hasNext()) {
//			Certification certification = certifications.next();
//			Resource certificationProfile = model.createResource(
//					certificationUri + "3" + professional.getName() + "/Certification/" + certification.getTitle());
//			model.add(professionalProfile, hasCertification, certificationProfile);
//		}

		
//		if (professional.getRecommended_visitors() != null) {
//		Iterator<RecommandedVisitor> visitors = professional.getRecommended_visitors().iterator();
//		while (visitors.hasNext()) {
//			RecommandedVisitor visitor = visitors.next();
//			Resource visitorProfile = model.createResource(
//					professionalUri + "/" + professional.getName() + "/Recommended_visitor/" + visitor.getName());
//			model.add(professionalProfile, hasRecommandedVisitor, visitorProfile);
//			if (visitor.getName() != null)
//				model.add(visitorProfile, name, visitor.getName());
//			if (visitor.getTitle() != null)
//				model.add(visitorProfile, industry, visitor.getTitle());
//			if (visitor.getLink() != null)
//				model.add(visitorProfile, picture, visitor.getLink());
//			if (visitor.getCompany() != null)
//				model.add(visitorProfile, linkedin_url, visitor.getCompany());
//		}
//	}
		

		model.write(System.out , "RDF/XML-ABBREV");

				FileOutputStream out = null;
				try {
					out = new FileOutputStream("test.rdf");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				model.write(out);
				
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	

	}
	  
	public static void getPostType (JobCompany job, Resource post) {
	
		String description = "";
		
		if (job.getDescription() != null)
			description = job.getDescription();
		
	if (job.getTitle().toLowerCase().contains("teacher") ||
			description.toLowerCase().contains("teacher") ||
			job.getTitle().toLowerCase().contains("enseignant")  ||
			description.toLowerCase().contains("enseignant") ||
			job.getTitle().toLowerCase().contains("professor")  ||
			description.toLowerCase().contains("professor") ||
			job.getTitle().toLowerCase().contains("assistant")  ||
			description.toLowerCase().contains("assistant") ||
			job.getTitle().toLowerCase().contains("professeur")  ||
			description.toLowerCase().contains("professeur") 
			)
  
	 model.add(post, RDF.type, classTeacher);
   
		 else if (job.getTitle().toLowerCase().contains("trainee") ||
				 description.toLowerCase().contains("trainee")  ||
				 job.getTitle().toLowerCase().contains("intern") ||
				 description.toLowerCase().contains("intern")  ||
				 job.getTitle().toLowerCase().contains("stage")  ||
				 description.toLowerCase().contains("stage") ||
				 job.getTitle().toLowerCase().contains("internship")  ||
				 description.toLowerCase().contains("internship")||
				 description.toLowerCase().contains("stagiaire") ||
				 job.getTitle().toLowerCase().contains("stagiaire"))

	model.add(post, RDF.type, classTrainee);
	

	else if (job.getTitle().toLowerCase().contains("ingenieur") ||
			description.toLowerCase().contains("ingenieur")  ||
			job.getTitle().toLowerCase().contains("engineer")  ||
			description.toLowerCase().contains("engineer") )

	{
		if (job.getTitle().toLowerCase().contains("securite") ||
				description.toLowerCase().contains("security")  )
			
			model.add(post, RDF.type, classSecurityEngineer);
	
		else if (job.getTitle().toLowerCase().contains("r&d") ||
					description.toLowerCase().contains("r&d")  ||
					job.getTitle().toLowerCase().contains("r & d")  ||
					description.toLowerCase().contains("r & d") )
			
		model.add(post, RDF.type, classRandDEngineer);
	
		else if (job.getTitle().toLowerCase().contains("software") ||
						description.toLowerCase().contains("software")  ||
						job.getTitle().toLowerCase().contains("developpement")  ||
						description.toLowerCase().contains("developpement") ||
						job.getTitle().toLowerCase().contains("development")  ||
						description.toLowerCase().contains("development") ||
						job.getTitle().toLowerCase().contains("logiciel")  ||
						description.toLowerCase().contains("logiciel") ||
						job.getTitle().toLowerCase().contains("developer")  ||
						description.toLowerCase().contains("developer") ||
						job.getTitle().toLowerCase().contains("developpeur")  ||
						description.toLowerCase().contains("developpeur") )
			
		model.add(post, RDF.type, classDevelopmentEngineer);
	
	else model.add(post, RDF.type, classEngineer);
	
	} 


	else model.add(post, RDF.type, classPost);
		
	}
  

}

