package com.websemproject.linkedin.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.websemproject.linkedin.model.Professional;
import com.websemproject.linkedin.model.Skill;
import com.websemproject.linkedin.parser.ParserRDF;
import com.websemproject.linkedin.sparql.ManagerSparql;
import com.websemproject.linkedin.sparql.ProfessionalDetails;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ManagerController {

//	String workingDir = "C:" + "\\Users" + "\\MounirG" + "\\Documents" + "\\workspace-sts-3.7.2.RELEASE"
//			+ "\\WebSemantic_Project";

	 String workingDir = "C:" + "\\Users" + "\\Farouk" + "\\Desktop" +
	 "\\Cours" + "\\web semantique"
	 + "\\WebSemantic_Project";

	String fileSource = workingDir + "\\attached_files";

	List<String> names;
	Professional currentProfessional;
	ParserRDF parser = new ParserRDF();

	List<MentionedProfessional> mentionedProfessionals;
	
	ManagerSparql managerSparql= new ManagerSparql();

	public void putNames() {
		names = new ArrayList<String>();
		names.add("Mounir Guizani");
		names.add("Jomaa Farouk");
		names.add("Achraf Aouadi");
		names.add("Ahmed REBAI");
		names.add("Amen Ouali");
		names.add("Hela Tajouri");
		names.add("Ramzi Zayene");
		names.add("Syrine Tlili, PhD");
		names.add("Yassin Ben Naceur");
		names.add("Khaled Ben Driss");
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		putNames();
		model.addAttribute("allNames", names);
		return "login";
	}

	@RequestMapping(value = "/generalInformations", method = RequestMethod.GET)
	public String generalInformations(Model model) {
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("firstName", currentProfessional.getFirst_name());
		model.addAttribute("lastName", currentProfessional.getLast_name());
		model.addAttribute("location", currentProfessional.getLocation());
		model.addAttribute("title", currentProfessional.getTitle());
		model.addAttribute("numberOfConnections", currentProfessional.getNumber_of_connections());
		model.addAttribute("country", currentProfessional.getCountry());
		model.addAttribute("industry", currentProfessional.getIndustry());
		model.addAttribute("summary", currentProfessional.getSummary());
		return "generalInformations";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		putNames();
		model.addAttribute("allNames", names);
		return "login";
	}

	@RequestMapping(value = "/certifications", method = RequestMethod.GET)
	public String certifications(Model model) {
		if (currentProfessional.getCertifications() != null)
			model.addAttribute("allCertifications", currentProfessional.getCertifications());
		currentProfessional.showAllCertifications(currentProfessional.getCertifications());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "certifications";
	}

	@RequestMapping(value = "/currentPosts", method = RequestMethod.GET)
	public String currentPosts(Model model) {
		model.addAttribute("posts", currentProfessional.getCurrent_companies());
		currentProfessional.showAllJobCompany(currentProfessional.getCurrent_companies());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "currentPosts";
	}

	@RequestMapping(value = "/pastPosts", method = RequestMethod.GET)
	public String pastPosts(Model model) {
		model.addAttribute("posts", currentProfessional.getPast_companies());
		currentProfessional.showAllJobCompany(currentProfessional.getPast_companies());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "pastPosts";
	}

	@RequestMapping(value = "/groups", method = RequestMethod.GET)
	public String groups(Model model) {
		model.addAttribute("allGroups", currentProfessional.getGroups());
		currentProfessional.showAllGroups(currentProfessional.getGroups());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "groups";
	}

	@RequestMapping(value = "/educations", method = RequestMethod.GET)
	public String educations(Model model) {
		model.addAttribute("allEducations", currentProfessional.getEducation());
		currentProfessional.showAllEducations(currentProfessional.getEducation());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "educations";
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String projects(Model model) {
		model.addAttribute("allProjects", currentProfessional.getProjects());
		currentProfessional.showAllProjects(currentProfessional.getProjects());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "projects";
	}

	@RequestMapping(value = "/recommandedVisitors", method = RequestMethod.GET)
	public String recommandedSkills(Model model) {
		model.addAttribute("allRecommandedVisitors", currentProfessional.getRecommended_visitors());
		currentProfessional.showAllRecommended_visitor(currentProfessional.getRecommended_visitors());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "recommandedVisitors";
	}

	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String skills(Model model) {
		model.addAttribute("allSkills", currentProfessional.getSkillsAll());
		currentProfessional.showAllSkills(currentProfessional.getSkillsAll());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "skills";
	}

	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String friends(Model model) {
		model.addAttribute("allFriends", currentProfessional.getFriends());
		currentProfessional.showAllFriends(currentProfessional.getFriends());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "friends";
	}

	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public String languages(Model model) {
		if (currentProfessional.getLanguages() != null)
			model.addAttribute("allLanguages", currentProfessional.getLanguages());
		currentProfessional.showAllStrings((currentProfessional.getLanguages()));
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "languages";
	}

	@RequestMapping(value = "/findProfileWithName", method = RequestMethod.GET)
	public String findProfileWithName(@RequestParam("profileName") String profileName, Model model) {
		System.out.println(fileSource);
		currentProfessional = parser.fromRdfFileToProfessional(fileSource, profileName);
		initiate(profileName);
		model.addAttribute("mentionedProfessionals",mentionedProfessionals);
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("firstName", currentProfessional.getFirst_name());
		model.addAttribute("lastName", currentProfessional.getLast_name());
		model.addAttribute("location", currentProfessional.getLocation());
		model.addAttribute("title", currentProfessional.getTitle());
		model.addAttribute("numberOfConnections", currentProfessional.getNumber_of_connections());
		model.addAttribute("country", currentProfessional.getCountry());
		model.addAttribute("industry", currentProfessional.getIndustry());
		model.addAttribute("summary", currentProfessional.getSummary());
		return "generalInformations";
	}

	public void initiate(String profileName) {
		ProfessionalDetails professionalDetails = new ProfessionalDetails();
		Professional professional = new Professional();
		professional.setName(profileName);
		professionalDetails.setProfessional(professional);
		managerSparql.initiate(professionalDetails);
		Iterator<String> iterator=names.iterator();
		while (iterator.hasNext()){
			MentionedProfessional mentionedProfessional = new MentionedProfessional();
             String name=iterator.next();
             if (!name.equals(profileName))
             {
             mentionedProfessional.setName(name);
             if (positionInList(name, professionalDetails.getHasSecondDegreeFriend())!=-1)
             mentionedProfessional.setDegree("2");
             if (positionInList(name, professionalDetails.getHasThirdDegreeFriend())!=-1)
             mentionedProfessional.setDegree("3");
             if (positionInList(name, professionalDetails.getWorkedInSameCompany())!=-1)
                 mentionedProfessional.setDegree("Worked in same company");
             if (positionInList(name, professionalDetails.getWentSameUniversityAs())!=-1)
                 mentionedProfessional.setDegree("Went Same University");
             if (positionInList(name, professionalDetails.getIsColleagueOf())!=-1)
                 mentionedProfessional.setDegree("Colleague in company");
             }
             mentionedProfessionals.add(mentionedProfessional);
             }
		Iterator<Skill> iteratorSkills=currentProfessional.getSkillsAll().iterator();
		int positionSkill=0;
		while (iteratorSkills.hasNext()){
			Skill skill=iteratorSkills.next();
			if (positionInList(skill.getName(), professionalDetails.getIsExpertIn())!=-1)
			currentProfessional.getSkillsAll().get(positionSkill).setLevel("Expert");	
			if (positionInList(skill.getName(), professionalDetails.getHasBasicCommunicationSkillsIn())!=-1)
				currentProfessional.getSkillsAll().get(positionSkill).setLevel("Basic");
		}
		if (professionalDetails.getIsGraduated().get(0).equals("true"))
			currentProfessional.setGraduated("Graduated");
		else 
			currentProfessional.setGraduated("Not Graduated");
	}

	public int positionInList(String variable, List<String> list) {
		boolean exist = false;
		int position = 0;
		Iterator<String> iterator = list.iterator();
		while ((iterator.hasNext()) && (exist == false)) {
			String element = iterator.next();
			if (element.equals(variable))
				exist = true;
			position++;
		}
		if (exist == false)
			return position;
		else
			return -1;
	}

}
