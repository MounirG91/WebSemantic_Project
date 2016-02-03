package com.websemproject.linkedin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.websemproject.linkedin.model.Professional;
import com.websemproject.linkedin.parser.ParserXML;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ManagerController {
	String workingDir = "C:" + "\\Users" + "\\MounirG" + "\\Documents" + "\\workspace-sts-3.7.2.RELEASE"
			+ "\\WebSemProject";

	String fileSource=workingDir+"\\attached_files";
	List<String> names; 
	Professional currentProfessional;
	ParserXML parser = new ParserXML();
	
public static String main(String[] args) throws NullPointerException, ParseException, IOException {
		
		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);
		
		return workingDir + "\\attached_files";
		}

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
		if (currentProfessional.getCertifications()!=null)
		model.addAttribute("allCertifications",currentProfessional.getCertifications());
		currentProfessional.showAllCertifications(currentProfessional.getCertifications());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "certifications";
	}

	@RequestMapping(value = "/currentPosts", method = RequestMethod.GET)
	public String currentPosts(Model model) {
		model.addAttribute("posts",currentProfessional.getCurrent_companies());
		currentProfessional.showAllJobCompany(currentProfessional.getCurrent_companies());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "currentPosts";
	}

	@RequestMapping(value = "/pastPosts", method = RequestMethod.GET)
	public String pastPosts(Model model) {
		model.addAttribute("posts",currentProfessional.getPast_companies());
		currentProfessional.showAllJobCompany(currentProfessional.getPast_companies());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "pastPosts";
	}

	@RequestMapping(value = "/groups", method = RequestMethod.GET)
	public String groups(Model model) {
		model.addAttribute("allGroups",currentProfessional.getGroups());
		currentProfessional.showAllGroups(currentProfessional.getGroups());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "groups";
	}
	
	@RequestMapping(value = "/educations", method = RequestMethod.GET)
	public String educations(Model model) {
		model.addAttribute("allEducations",currentProfessional.getEducation());
		currentProfessional.showAllEducations(currentProfessional.getEducation());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "educations";
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String projects(Model model) {
		model.addAttribute("allProjects",currentProfessional.getProjects());
		currentProfessional.showAllProjects(currentProfessional.getProjects());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "projects";
	}

	@RequestMapping(value = "/recommandedVisitors", method = RequestMethod.GET)
	public String recommandedSkills(Model model) {
		model.addAttribute("allRecommandedVisitors",currentProfessional.getRecommended_visitors());
		currentProfessional.showAllRecommended_visitor(currentProfessional.getRecommended_visitors());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "recommandedVisitors";
	}

	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String skills(Model model) {
		model.addAttribute("allSkills",currentProfessional.getSkillsAll());
		currentProfessional.showAllSkills(currentProfessional.getSkillsAll());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "skills";
	}

	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String friends(Model model) {
		model.addAttribute("allFriends",currentProfessional.getFriends());
		currentProfessional.showAllFriends(currentProfessional.getFriends());
		model.addAttribute("name", currentProfessional.getName());
		model.addAttribute("linkedinURL", currentProfessional.getLinkedin_url());
		model.addAttribute("linkedinPicture", currentProfessional.getPicture());
		return "friends";
	}
	
	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public String languages(Model model) {
		if (currentProfessional.getLanguages()!=null)
		model.addAttribute("allLanguages",currentProfessional.getLanguages());
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

}
