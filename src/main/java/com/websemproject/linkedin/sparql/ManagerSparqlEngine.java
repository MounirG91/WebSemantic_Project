package com.websemproject.linkedin.sparql;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

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
		
		List<String> skills = new ArrayList<String>();
		skills.add("Java");
		skills.add("Network Security");
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
		itcertifs.add("SCJP");

		List<String> countries = new ArrayList<String>();
		countries.add("Tunisia");
		countries.add("France");
		countries.add("Germany");

		List<String> educs = new ArrayList<String>();
		educs.add("engineeringStudies");
		educs.add("others");

		List<String> univs = new ArrayList<String>();
		univs.add("École centrale de Lille");
		univs.add("Concordia University, Montreal, Quebec");

		List<String> companies = new ArrayList<String>();
		companies.add("adhoc International");
		companies.add("Agence Nationale de la Certification Electronique");
		companies.add("TEKonsult");

		String grad_or_student = "graduated"; //or "student"

//		System.out.println(executeQuery(null, null, null, null, null, educs, 
//				null, null, countries, univs, companies, null, null, null) );

		System.out.println(managerSparqlEngine.executeQuery(skills, lang, indus, langcertifs, itcertifs, educs, 
				null, null, countries, univs, companies, null, null, grad_or_student));
	}

	public void initiate() {
	String workingDir = "C:" + "\\Users" + "\\MounirG" + "\\Documents" + "\\workspace-sts-3.7.2.RELEASE"
				+ "\\WebSemantic_Project";

		 //String workingDir = "C:" + "\\Users" + "\\Farouk" + "\\Desktop" +
		 //"\\Cours" + "\\web semantique"
		 //+ "\\WebSemantic_Project";

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
			
			byte ptext[] = dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()).getBytes(); 
			String value = "";
			try {
			 value = new String(ptext, "UTF8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			list.add(value);

		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "-- No Skills --");
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
		list.add(0, "-- No Languages --");

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
			byte ptext[] = dt.stringValue().getBytes(); 
			String value = "";
			try {
			 value = new String(ptext, "UTF8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			list.add(value);
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "-- No Industries --");
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
		list.add(0, "-- No Languages Certifications --");
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
		list.add(0, "-- No Certifications --");
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
		list.add(0, "-- No Educations --");

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
		list.add(0, "-- No Current Positions --");

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
		list.add(0, "-- No Past Positions --");

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
		list.add(0, "-- No Countries --");
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
			
			byte ptext[] = dt.stringValue().getBytes(); 
			String value = "";
			try {
			 value = new String(ptext, "UTF8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			list.add(value.substring(value.indexOf("#") + 1, value.length()));
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "-- No Universities --");
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
			
			byte ptext[] = dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()).getBytes(); 
			String value = "";
			try {
			 value = new String(ptext, "UTF8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			list.add(value);

			dt = (IDatatype) m.getValue("?w");
			
			byte ptext2[] = dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()).getBytes(); 
			String value2 = "";
			try {
			 value2 = new String(ptext2, "UTF8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			list.add(value2);


		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		list.add(0, "-- No Companies --");
		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		return list;
	}

	public List<String> executeQuery(List<String> skills, List<String> languages, List<String> industries,
			List<String> languagesCertifs, List<String> itCertifs, List<String> educations, List<String> currentPost,
			List<String> pastPost, List<String> countries, List<String> universities, List<String> companies,
			String fluentBasic, String expert, String graduatedOrStudent) {

		List<String> list = new ArrayList<String>();
		String uri = "http://linkedin_project.com/profile.rdfs-instances/";
		String base = "http://linkedin_project.com/profile.rdfs#";

		// Skills prepare query
		String query_skills = " ";

		if (skills != null) {
			String sub_query_skills = "";

			for (int i = 0; i < skills.size(); i++) {
				sub_query_skills += "str(?y) = \"" + uri + "Skill/#" + skills.get(i) + "\"";
				if (i != (skills.size() - 1))
					sub_query_skills += " || ";
			}

			query_skills = "select  ?x " + "where { "
					+ "?x lp:hasSkill ?y" + " FILTER (" + sub_query_skills + ")" + " }";
		}

		// Languages prepare query
		String query_lang = " ";

		if (languages != null) {
			String sub_query_lang = "";

			for (int i = 0; i < languages.size(); i++) {
				sub_query_lang += "str(?y) = \"" + uri + "Language/#" + languages.get(i) + "\"";
				if (i != (languages.size() - 1))
					sub_query_lang += " || ";
			}

			query_lang =  "select  ?x " + "where { "
					+ "?x lp:speacksLanguage ?y" + " FILTER (" + sub_query_lang + ")" + " }";
		}

		// Industries prepare query
		String query_ind = " ";

		if (industries != null) {
			String sub_query_ind = "";

			for (int i = 0; i < industries.size(); i++) {
				sub_query_ind += "str(?y) = \"" + industries.get(i) + "\"";
				if (i != (industries.size() - 1))
					sub_query_ind += " || ";
			}

			query_ind =  "select  ?x " + "where { "
					+ "?x lp:industry ?y" + " FILTER (" + sub_query_ind + ")" + " }";

		}

		// langCertifs prepare query
		String query_lang_certif = " ";

		if (languagesCertifs != null) {
			String sub_query_lang_certif = "";

			for (int i = 0; i < languagesCertifs.size(); i++) {
				sub_query_lang_certif += "str(?z) = \"" + uri + "certificationInfoBox/#" + languagesCertifs.get(i)
						+ "\"";
				if (i != (languagesCertifs.size() - 1))
					sub_query_lang_certif += " || ";
			}

			query_lang_certif =  "select  ?x " + "where { "
					+ "?x lp:hasCertification ?y " + "?y rdf:type \"" + base + "languageCertification\" "
					+ "?y lp:hasInfoBox ?z " + " FILTER (" + sub_query_lang_certif + ")" + " }";

		}

		// itCertifs prepare query
		String query_it_certif = " ";

		if (itCertifs != null) {
			String sub_query_it_certif = "";

			for (int i = 0; i < itCertifs.size(); i++) {
				sub_query_it_certif += "str(?z) = \"" + uri + "certificationInfoBox/#" + itCertifs.get(i) + "\"";
				if (i != (itCertifs.size() - 1))
					sub_query_it_certif += " || ";
			}

			query_it_certif = "select  ?x " + "where { "
					+ "?x lp:hasCertification ?y " + "?y rdf:type \"" + base + "ITCertification\" "
					+ "?y lp:hasInfoBox ?z " + " FILTER (" + sub_query_it_certif + ")" + " }";

		}

		
		// countries prepare query
		String query_countries = " ";

		if (countries != null) {
			String sub_query_countries = "";

			for (int i = 0; i < countries.size(); i++) {
				String count = countries.get(i);
				
				if (count.equalsIgnoreCase("Germany"))
				{
				sub_query_countries += "str(?y) = \"" + uri + "Country/#Germany\"";
				sub_query_countries += " || ";
				sub_query_countries += "str(?y) = \"" + uri + "Country/#Allemagne\"";
				sub_query_countries += " || ";
				sub_query_countries += "str(?y) = \"" + uri + "Country/#Deutschland\"";

				if (i != (countries.size() - 1))
					sub_query_countries += " || ";
				}
				else if (count.equalsIgnoreCase("Tunisia"))
				{
					sub_query_countries += "str(?y) = \"" + uri + "Country/#Tunisia\"";
					sub_query_countries += " || ";
					sub_query_countries += "str(?y) = \"" + uri + "Country/#Tunisie\"";

					if (i != (countries.size() - 1))
					sub_query_countries += " || ";
				}
				else
				{
				sub_query_countries += "str(?y) = \"" + uri + "Country/#" + countries.get(i) + "\"";
				if (i != (countries.size() - 1))
					sub_query_countries += " || ";
				}
			}

			query_countries =  "select  ?x " + "where { "
					+ "?x lp:country ?y " + 
					" FILTER (" + sub_query_countries + ")" + " }";

		}
		
		
		
		// educations prepare query
		String query_educ = " ";

		if (educations != null) {
			String sub_query_educ = "";

			for (int i = 0; i < educations.size(); i++) {
				if (educations.get(i).equalsIgnoreCase("others"))
				{sub_query_educ += "{?y rdf:type \"" + base + "Education\"}";}
				else {sub_query_educ += "{?y rdf:type \"" + base + educations.get(i) + "\"}";}
				
				if (i != (educations.size() - 1))
					sub_query_educ += " UNION ";
			}

			query_educ =  "select  ?x " + "where { "
					+ "?x lp:hasEducation ?y " + 
					 sub_query_educ +  " }";

		}
		
	
		// universities prepare query
		String query_univ = " ";

		if (universities != null) {
			String sub_query_univ = "";

			for (int i = 0; i < universities.size(); i++) {
				sub_query_univ += "str(?z) = \"" + uri + "University/#" + universities.get(i) + "\"";
				if (i != (universities.size() - 1))
					sub_query_univ += " || ";
			}

			query_univ =  "select  ?x " + "where { "
					+ "?x lp:hasEducation ?y  ?y lp:doneInUniversity ?z" + 
					" FILTER (" + sub_query_univ + ")" + " }";

		}
		
		// grad_stud prepare query
		String grad_stud = " ";

		if (graduatedOrStudent != null) {
			String sub_query_grad_stud = "";

			if (graduatedOrStudent.equals("graduated"))
			grad_stud =  "select  ?x " + "where { "
					+ "?x lp:isGraduated \"true\" }";
			else if (graduatedOrStudent.equals("student"))
				grad_stud =  "select  ?x " + "where { "
						+ "?x lp:isStillStudentAt ?z }";


		}
	
		
		// companies prepare query
		String query_companies = " ";

		if (companies != null) {
			String sub_query_companies = "";

			for (int i = 0; i < companies.size(); i++) {
				sub_query_companies += "(str(?z) = \"" + uri + "Company/#" + companies.get(i) + "\" || "
						+ "str(?w) = \"" + uri + "Company/#" + companies.get(i) + "\")";
				if (i != (companies.size() - 1))
					sub_query_companies += " || ";
			}

			query_companies =  "select  ?x " + "where { "
					+ "?x lp:hasPosition ?y  ?y lp:tookPlaceIn ?z ?x lp:hadPosition ?t ?t lp:tookPlaceIn ?w" + 
					" FILTER (" + sub_query_companies + ")" + " }";

		}
		
		String first_query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> ";
		
		if (skills != null)
			first_query += query_skills;
		else if (universities != null)
			first_query += query_univ;
		else if (languages != null)
			first_query += query_lang;
		else if (industries != null)
			first_query += query_ind;
		else if (countries != null)
			first_query += query_countries;
		else if (languagesCertifs != null)
			first_query += query_lang_certif;
		else if (itCertifs != null)
			first_query += query_it_certif;
		else if (grad_stud != null)
			first_query += grad_stud;
		else if (companies != null)
			first_query += query_companies;
		else if (educations != null)
			first_query += query_educ;

		System.out.println(first_query);
		
		
		String query = first_query.substring(0,first_query.lastIndexOf("}"))+" { "+query_univ+"}}";
		query = query.substring(0,query.lastIndexOf("}")-2)+" { "+query_lang+"}}}}";
		query = query.substring(0,query.lastIndexOf("}")-4)+" { "+query_ind+"}}}}}}";
		query = query.substring(0,query.lastIndexOf("}")-6)+" { "+query_countries+"}}}}}}}}";
		query = query.substring(0,query.lastIndexOf("}")-8)+" { "+query_lang_certif+"}}}}}}}}}}";
		query = query.substring(0,query.lastIndexOf("}")-10)+" { "+query_it_certif+"}}}}}}}}}}}}";
		query = query.substring(0,query.lastIndexOf("}")-12)+" { "+grad_stud+"}}}}}}}}}}}}}}";
		query = query.substring(0,query.lastIndexOf("}")-14)+" { "+query_companies+"}}}}}}}}}}}}}}}}";
		query = query.substring(0,query.lastIndexOf("}")-16)+" { "+query_educ+"}}}}}}}}}}}}}}}}}}";

		int count = StringUtils.countMatches(query, "{");
		int diff = StringUtils.countMatches(query, "}")-count;

		query = query.substring(0 , query.lastIndexOf("}")-(diff-1));

//		System.out.println(grad_stud);
//		System.out.println(query_skills);
//		System.out.println(query_lang);
//		System.out.println(query_ind);
//		System.out.println(query_lang_certif);
//		System.out.println(query_it_certif);
//		System.out.println(query_countries);
//		System.out.println(query_univ);
//		System.out.println(query_educ);

		//System.out.println(query);

		try {
			query = new String(query.getBytes("UTF-8"), "Windows-1252");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(query);
		
		QueryProcess exec = QueryProcess.create(gr);
		Mappings map = null;
		try {
			map = exec.query(query);
		} catch (EngineException e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?x");
			list.add(dt.stringValue().substring(dt.stringValue().indexOf("#") + 1, dt.stringValue().length()));
			}
			
		Set<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);

		java.util.Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

		
		return list;
	}


}