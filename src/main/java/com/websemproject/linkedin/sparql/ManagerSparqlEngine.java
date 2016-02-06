package com.websemproject.linkedin.sparql;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.inria.acacia.corese.api.IDatatype;
import fr.inria.acacia.corese.exceptions.EngineException;
import fr.inria.edelweiss.kgram.core.Mapping;
import fr.inria.edelweiss.kgram.core.Mappings;
import fr.inria.edelweiss.kgraph.core.Graph;
import fr.inria.edelweiss.kgraph.query.QueryProcess;
import fr.inria.edelweiss.kgraph.rule.RuleEngine;
import fr.inria.edelweiss.kgtool.load.Load;

public class ManagerSparqlEngine {

	static Graph gr;

	public ManagerSparqlEngine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerSparqlEngine managerSparqlEngine = new ManagerSparqlEngine();
		managerSparqlEngine.initiate();
		System.out.println(managerSparqlEngine.get_AllSkills());
		System.out.println(managerSparqlEngine.get_AllLanguages());
		System.out.println(managerSparqlEngine.get_AllIndustries());
		System.out.println(managerSparqlEngine.get_AllLanguageCertifs());
		System.out.println(managerSparqlEngine.get_AllITCertifs());
		System.out.println(managerSparqlEngine.get_AllEducations());
		System.out.println(managerSparqlEngine.get_AllCurrentPositions());
		System.out.println(managerSparqlEngine.get_AllPastPositions());
		System.out.println(managerSparqlEngine.get_AllCountries());
		System.out.println(managerSparqlEngine.get_AllUniversities());
		System.out.println(managerSparqlEngine.get_AllCompanies());
	}

	public void initiate() {
		String workingDir = "C:" + "\\Users" + "\\MounirG" + "\\Documents" + "\\workspace-sts-3.7.2.RELEASE"
				+ "\\WebSemantic_Project";

		// String workingDir = "C:" + "\\Users" + "\\Farouk" + "\\Desktop" +
		// "\\Cours" + "\\web semantique"
		// + "\\WebSemantic_Project";

		String fileSource = workingDir + "\\attached_files";

		gr = Graph.create(true);

		Load ld = Load.create(gr);

		try {
			ld.loadWE(fileSource + "\\linkedin.rdfs");
			ld.loadWE(fileSource + "\\certifications.rdf");
			ld.loadWE(fileSource + "\\universities.rdf");
			ld.loadWE(fileSource + "\\skills.rdf");
			ld.loadWE(fileSource + "\\linkedin.rul");
			ld.loadWE(fileSource + "\\Achraf Aouadi.rdf");
			ld.loadWE(fileSource + "\\Ahmed REBAI.rdf");
			ld.loadWE(fileSource + "\\Amen Ouali.rdf");
			ld.loadWE(fileSource + "\\Hela Tajouri.rdf");
			ld.loadWE(fileSource + "\\Jomaa Farouk.rdf");
			ld.loadWE(fileSource + "\\Khaled Ben Driss.rdf");
			ld.loadWE(fileSource + "\\Mounir Guizani.rdf");
			ld.loadWE(fileSource + "\\Ramzi Zayene.rdf");
			ld.loadWE(fileSource + "\\Syrine Tlili, PhD.rdf");
			ld.loadWE(fileSource + "\\Yassin Ben Naceur.rdf");
		} catch (Exception e) {
		}

		RuleEngine re = new RuleEngine();
		re = ld.getRuleEngine();
		re.process();
		gr.addEngine(re);
		gr.process();

		/*
		 * System.out.println (get_AllSkills ()); System.out.println
		 * (get_AllLanguages ()); System.out.println (get_AllIndustries ());
		 * System.out.println (get_AllLanguageCertifs ()); System.out.println
		 * (get_AllITCertifs ()); System.out.println (get_AllEducations ());
		 * System.out.println (get_AllCurrentPositions ()); System.out.println
		 * (get_AllPastPositions ()); System.out.println (get_AllCountries ());
		 * System.out.println (get_AllUniversities ()); System.out.println
		 * (get_AllCompanies ());
		 */

		List<String> skills = new ArrayList<String>();
		skills.add("Java");
		skills.add("C++");
		skills.add("ABAP");

		List<String> lang = new ArrayList<String>();
		lang.add("Arabe");
		lang.add("English");

		List<String> indus = new ArrayList<String>();
		indus.add("Computer Software");
		indus.add("Computer-Software");

		List<String> langcertifs = new ArrayList<String>();
		langcertifs.add("TOEIC");

		List<String> itcertifs = new ArrayList<String>();
		itcertifs.add("LPIC1");
		itcertifs.add("SCJP");

		executeQuery(skills, lang, indus, langcertifs, itcertifs, null, null, null, null, null, null, null, null);

	}

	public List<String> get_AllSkills() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasSkill ?y  }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "");
		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		return list;
	}

	public List<String> get_AllLanguages() {

		List<String> list = new ArrayList<String>();
		
		

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:speacksLanguage ?y  }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "");

		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		return list;
	}

	public List<String> get_AllIndustries() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:industry ?y  }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "");
		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		return list;
	}

	public List<String> get_AllLanguageCertifs() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasCertification ?y "
				+ " ?y rdf:type \"http://linkedin_project.com/profile.rdfs#languageCertification\" }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "");
		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		return list;
	}

	public List<String> get_AllITCertifs() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasCertification ?y "
				+ " ?y rdf:type \"http://linkedin_project.com/profile.rdfs#ITCertification\" }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "");
		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		return list;
	}

	public List<String> get_AllEducations() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasEducation ?z " + " ?z rdf:type ?y }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
		}

		list.add("Others");

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);

		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		list.remove(0);
		list.add(0, "");

		return list;
	}

	public List<String> get_AllCurrentPositions() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasPosition ?z " + " ?z rdf:type ?y }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
		}

		list.add("Others");

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);

		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		list.remove(2);
		list.add(0, "");

		return list;
	}

	public List<String> get_AllPastPositions() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hadPosition ?z " + " ?z rdf:type ?y }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
		}

		list.add("Others");

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);

		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		list.remove(1);
		list.add(0, "");

		return list;
	}

	public List<String> get_AllCountries() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:country ?y  }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			if (dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length())
					.equalsIgnoreCase("Deutschland")
					|| dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length())
							.equalsIgnoreCase("Allemagne"))
				list.add("Germany");

			else if (dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length())
					.equalsIgnoreCase("Tunisie"))
				list.add("Tunisia");
			else
				list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "");
		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		return list;
	}

	public List<String> get_AllUniversities() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasEducation ?z ?z lp:doneInUniversity ?y }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "");
		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		return list;
	}

	public List<String> get_AllCompanies() {

		List<String> list = new ArrayList<String>();

		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasPosition ?z  ?x lp:hadPosition ?t ?z lp:tookPlaceIn ?y ?t lp:tookPlaceIn ?w }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
			dt = (IDatatype) m.getValue("?w");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));

		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "");
		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		return list;
	}

	public List<String> executeQuery(List<String> skills, List<String> languages, List<String> industries,
			List<String> languagesCertifs, List<String> itCertifs, List<String> educations, List<String> currentPost,
			List<String> pastPost, List<String> countries, List<String> universities, List<String> companies,
			String fluentBasic, String expert) {

		List<String> list = new ArrayList<String>();
		String uri = "http://linkedin_project.com/profile.rdfs-instances/";
		String base = "http://linkedin_project.com/profile.rdfs#";

		// Skills prepare query
		String query_skills = "";

		if (skills != null) {
			String sub_query_skills = "";

			for (int i = 0; i < skills.size(); i++) {
				sub_query_skills += "str(?y) = \"" + uri + "Skill/#" + skills.get(i) + "\"";
				if (i != (skills.size() - 1))
					sub_query_skills += " || ";
			}

			query_skills = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "select  ?x " + "where { "
					+ "?x lp:hasSkill ?y" + " FILTER (" + sub_query_skills + ")" + " }";
		}

		// Languages prepare query
		String query_lang = "";

		if (languages != null) {
			String sub_query_lang = "";

			for (int i = 0; i < languages.size(); i++) {
				sub_query_lang += "str(?y) = \"" + uri + "Language/#" + languages.get(i) + "\"";
				if (i != (languages.size() - 1))
					sub_query_lang += " || ";
			}

			query_lang = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "select  ?x " + "where { "
					+ "?x lp:speacksLanguage ?y" + " FILTER (" + sub_query_lang + ")" + " }";
		}

		// Industries prepare query
		String query_ind = "";

		if (industries != null) {
			String sub_query_ind = "";

			for (int i = 0; i < industries.size(); i++) {
				sub_query_ind += "str(?y) = \"" + industries.get(i) + "\"";
				if (i != (industries.size() - 1))
					sub_query_ind += " || ";
			}

			query_ind = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "select  ?x " + "where { "
					+ "?x lp:industry ?y" + " FILTER (" + sub_query_ind + ")" + " }";

		}

		// langCertifs prepare query
		String query_lang_certif = "";

		if (languagesCertifs != null) {
			String sub_query_lang_certif = "";

			for (int i = 0; i < languagesCertifs.size(); i++) {
				sub_query_lang_certif += "str(?z) = \"" + uri + "certificationInfoBox/#" + languagesCertifs.get(i)
						+ "\"";
				if (i != (languagesCertifs.size() - 1))
					sub_query_lang_certif += " || ";
			}

			query_lang_certif = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "select  ?x " + "where { "
					+ "?x lp:hasCertification ?y " + "?y rdf:type \"" + base + "languageCertification\" "
					+ "?y lp:hasInfoBox ?z " + " FILTER (" + sub_query_lang_certif + ")" + " }";

		}

		// langCertifs prepare query
		String query_it_certif = "";

		if (itCertifs != null) {
			String sub_query_it_certif = "";

			for (int i = 0; i < itCertifs.size(); i++) {
				sub_query_it_certif += "str(?z) = \"" + uri + "certificationInfoBox/#" + itCertifs.get(i) + "\"";
				if (i != (itCertifs.size() - 1))
					sub_query_it_certif += " || ";
			}

			query_it_certif = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "select  ?x " + "where { "
					+ "?x lp:hasCertification ?y " + "?y rdf:type \"" + base + "ITCertification\" "
					+ "?y lp:hasInfoBox ?z " + " FILTER (" + sub_query_it_certif + ")" + " }";

		}

		System.out.println(query_skills);
		System.out.println(query_lang);
		System.out.println(query_ind);
		System.out.println(query_lang_certif);
		System.out.println(query_it_certif);

		return list;
	}

}