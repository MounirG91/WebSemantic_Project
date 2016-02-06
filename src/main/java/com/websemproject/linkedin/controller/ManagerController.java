package com.websemproject.linkedin.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lowagie.text.xml.xmp.LangAlt;
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

	String workingDir = "C:" + "\\Users" + "\\MounirG" + "\\Documents" + "\\workspace-sts-3.7.2.RELEASE"
			+ "\\WebSemantic_Project";

	// String workingDir = "C:" + "\\Users" + "\\Farouk" + "\\Desktop"
	// +"\\Cours" + "\\web semantique" + "\\WebSemantic_Project";

	String fileSource = workingDir + "\\attached_files";

	List<String> names;
	Professional currentProfessional;
	ParserRDF parser = new ParserRDF();

	List<MentionedProfessional> mentionedProfessionals = new ArrayList<MentionedProfessional>();

	ManagerSparql managerSparql = new ManagerSparql();

	String currentProfileName;

	List<MentionnedLanguage> mentionedLanguages = new ArrayList<MentionnedLanguage>();

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
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
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
		model.addAttribute("situation",currentProfessional.getGraduated());
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
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		if (currentProfessional.getCertifications() != null)
			model.addAttribute("allCertifications", currentProfessional.getCertifications());
		currentProfessional.showAllCertifications(currentProfessional.getCertifications());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "certifications";
	}

	@RequestMapping(value = "/currentPosts", method = RequestMethod.GET)
	public String currentPosts(Model model) {
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		model.addAttribute("posts", currentProfessional.getCurrent_companies());
		currentProfessional.showAllJobCompany(currentProfessional.getCurrent_companies());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "currentPosts";
	}

	@RequestMapping(value = "/pastPosts", method = RequestMethod.GET)
	public String pastPosts(Model model) {
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		model.addAttribute("posts", currentProfessional.getPast_companies());
		currentProfessional.showAllJobCompany(currentProfessional.getPast_companies());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "pastPosts";
	}

	@RequestMapping(value = "/groups", method = RequestMethod.GET)
	public String groups(Model model) {
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		model.addAttribute("allGroups", currentProfessional.getGroups());
		currentProfessional.showAllGroups(currentProfessional.getGroups());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "groups";
	}

	@RequestMapping(value = "/educations", method = RequestMethod.GET)
	public String educations(Model model) {
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		model.addAttribute("allEducations", currentProfessional.getEducation());
		currentProfessional.showAllEducations(currentProfessional.getEducation());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "educations";
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String projects(Model model) {
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		model.addAttribute("allProjects", currentProfessional.getProjects());
		currentProfessional.showAllProjects(currentProfessional.getProjects());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "projects";
	}

	@RequestMapping(value = "/recommandedVisitors", method = RequestMethod.GET)
	public String recommandedSkills(Model model) {
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		model.addAttribute("allRecommandedVisitors", currentProfessional.getRecommended_visitors());
		currentProfessional.showAllRecommended_visitor(currentProfessional.getRecommended_visitors());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "recommandedVisitors";
	}

	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String skills(Model model) {
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		model.addAttribute("allSkills", currentProfessional.getSkillsAll());
		currentProfessional.showAllSkills(currentProfessional.getSkillsAll());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "skills";
	}

	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String friends(Model model) {
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		model.addAttribute("allFriends", currentProfessional.getFriends());
		currentProfessional.showAllFriends(currentProfessional.getFriends());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "friends";
	}

	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public String languages(Model model) {
		initiate(currentProfileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		if (currentProfessional.getLanguages() != null)
			model.addAttribute("allLanguages", mentionedLanguages);
		currentProfessional.showAllStrings((currentProfessional.getLanguages()));
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "languages";
	}

	@RequestMapping(value = "/findProfileWithName", method = RequestMethod.GET)
	public String findProfileWithName(@RequestParam("profileName") String profileName, Model model) {
		System.out.println(fileSource);
		currentProfessional = parser.fromRdfFileToProfessional(fileSource, profileName);
		this.currentProfileName = profileName;
		initiate(profileName);
		model.addAttribute("mentionedProfessionals", mentionedProfessionals);
		this.mentionedProfessionals = new ArrayList<MentionedProfessional>();
		this.mentionedLanguages=new ArrayList<MentionnedLanguage>();
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
		model.addAttribute("situation",currentProfessional.getGraduated());
		return "generalInformations";
	}

	public void initiate(String profileName) {
		ProfessionalDetails professionalDetails = new ProfessionalDetails();
		Professional professional = new Professional();
		professional.setName(profileName);
		professionalDetails.setProfessional(professional);
		managerSparql.initiate(professionalDetails);
		Iterator<String> iterator = names.iterator();
		while (iterator.hasNext()) {
			MentionedProfessional mentionedProfessional = new MentionedProfessional();
			String name = iterator.next();
			if (!(name.equals(profileName))) {
				mentionedProfessional.setName(name);
				if (existInList(name, professionalDetails.getHasSecondDegreeFriend()) == true)
					mentionedProfessional.setDegree("(2)");
				else if (existInList(name, professionalDetails.getHasThirdDegreeFriend()) == true)
					mentionedProfessional.setDegree("(3)");
				else
					mentionedProfessional.setDegree("(1)");
				if (existInList(name, professionalDetails.getWorkedInSameCompany()) == true)
					mentionedProfessional.setWorkedInSameCompany("(worked in same company)");
				if (existInList(name, professionalDetails.getWentSameUniversityAs()) == true)
					mentionedProfessional.setWorkedInSameCompany("(went same university)");
				if (existInList(name, professionalDetails.getIsColleagueOf()) == true)
					mentionedProfessional.setIsColleague("(colleague in company)");
				mentionedProfessionals.add(mentionedProfessional);
			}

		}
		Iterator<Skill> iteratorSkills = currentProfessional.getSkillsAll().iterator();
		int positionSkill = 0;
		while (iteratorSkills.hasNext()) {
			Skill skill = iteratorSkills.next();
			if (existInList(skill.getName(), professionalDetails.getIsExpertIn()) == true)
				currentProfessional.getSkillsAll().get(positionSkill).setLevel("(Expert)");
			if (existInList(skill.getName(), professionalDetails.getHasBasicCommunicationSkillsIn()) == true)
				currentProfessional.getSkillsAll().get(positionSkill).setLevel("(Basic)");
			positionSkill++;
		}
		if (professionalDetails.getIsGraduated().size() != 0) {
			if (professionalDetails.getIsGraduated().get(0).equals("true"))
				currentProfessional.setGraduated("(Graduated)");
		}

		if (professionalDetails.getIsStillStudentAt().size() != 0) {
			currentProfessional.setGraduated("(Student at " + professionalDetails.getIsStillStudentAt().get(0) + ")");
			;
		}

		Iterator<String> languages = currentProfessional.getLanguages().iterator();
		while (languages.hasNext()) {
			String language = languages.next();
			MentionnedLanguage mentionnedLanguage = new MentionnedLanguage();
			mentionnedLanguage.setName(language);
			if (existInList(language, professionalDetails.getIsFluentIn()) == true)
				mentionnedLanguage.setFluent("(Fluent)");
			mentionedLanguages.add(mentionnedLanguage);

		}

	}

	public boolean existInList(String variable, List<String> list) {
		boolean exist = false;
		Iterator<String> iterator = list.iterator();
		while ((iterator.hasNext()) && (exist == false)) {
			String element = iterator.next();
			if (element.equals(variable))
				exist = true;
		}
		return exist;
	}

}
