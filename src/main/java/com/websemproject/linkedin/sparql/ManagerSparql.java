package com.websemproject.linkedin.sparql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.websemproject.linkedin.model.Professional;

import fr.inria.acacia.corese.api.IDatatype;
import fr.inria.edelweiss.kgram.core.Mapping;
import fr.inria.edelweiss.kgram.core.Mappings;
import fr.inria.edelweiss.kgraph.core.Graph;
import fr.inria.edelweiss.kgraph.query.QueryProcess;
import fr.inria.edelweiss.kgraph.rule.RuleEngine;
import fr.inria.edelweiss.kgtool.load.Load;


public class ManagerSparql {

	static Graph gr;

	public ManagerSparql() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Test
	public static void main(String[] args) {
		ManagerSparql managerSparql = new ManagerSparql();
		ProfessionalDetails professionalDetails = new ProfessionalDetails();
		Professional professional = new Professional();
		professional.setName("Yassin Ben Naceur");
		professionalDetails.setProfessional(professional);
		managerSparql.initiate(professionalDetails);
	}

	public void initiate(ProfessionalDetails professionalDetails) {

//		String workingDir = "C:" + "\\Users" + "\\MounirG" + "\\Documents" + "\\workspace-sts-3.7.2.RELEASE"
//				+ "\\WebSemantic_Project";
		
		 String workingDir = "C:" + "\\Users" + "\\Farouk" + "\\Desktop" +
		 "\\Cours" + "\\web semantique"
		 + "\\WebSemantic_Project";	
		 
		String fileSource = workingDir + "\\attached_files";
		
		gr = Graph.create(true);

		Load ld = Load.create(gr);

		try {
			ld.loadWE(fileSource+"\\linkedin.rdfs");
			ld.loadWE(fileSource+"\\certifications.rdf");
			ld.loadWE(fileSource+"\\universities.rdf");
			ld.loadWE(fileSource+"\\skills.rdf");
			ld.loadWE(fileSource+"\\linkedin.rul");
			ld.loadWE(fileSource+"\\Achraf Aouadi.rdf");
			ld.loadWE(fileSource+"\\Ahmed REBAI.rdf");
			ld.loadWE(fileSource+"\\Amen Ouali.rdf");
			ld.loadWE(fileSource+"\\Hela Tajouri.rdf");
			ld.loadWE(fileSource+"\\Jomaa Farouk.rdf");
			ld.loadWE(fileSource+"\\Khaled Ben Driss.rdf");
			ld.loadWE(fileSource+"\\Mounir Guizani.rdf");
			ld.loadWE(fileSource+"\\Ramzi Zayene.rdf");
			ld.loadWE(fileSource+"\\Syrine Tlili, PhD.rdf");
			ld.loadWE(fileSource+"\\Yassin Ben Naceur.rdf");
		} catch (Exception e) {
		}

		RuleEngine re = ld.getRuleEngine();
		re.process();
		gr.addEngine(re);
		gr.process();
		
		professionalDetails.setHasSecondDegreeFriend(get_List_HasSecondDegreeFriend(professionalDetails.getProfessional().getName()));
		professionalDetails.setHasThirdDegreeFriend(get_List_HasThirdDegreeFriend(professionalDetails.getProfessional().getName()));
		professionalDetails.setWentSameUniversityAs(get_List_WentSameUniversityAs(professionalDetails.getProfessional().getName()));
		professionalDetails.setWorkedInSameCompany(get_List_WorkedInSameCompany(professionalDetails.getProfessional().getName()));
		professionalDetails.setIsColleagueOf(get_List_IsColleagueOf(professionalDetails.getProfessional().getName()));
		professionalDetails.setIsFluentIn(get_List_IsFluentIn(professionalDetails.getProfessional().getName()));
		professionalDetails.setHasBasicCommunicationSkillsIn(get_List_HasBasicCommunicationSkillsIn(professionalDetails.getProfessional().getName()));
		professionalDetails.setIsExpertIn(get_List_IsExpertIn(professionalDetails.getProfessional().getName()));
		professionalDetails.setIsStillStudentAt(get_List_IsStillStudentAt(professionalDetails.getProfessional().getName()));
		professionalDetails.setIsGraduated(get_List_IsGraduated(professionalDetails.getProfessional().getName()));
		
		
		transformList(professionalDetails.getHasSecondDegreeFriend());
		transformList(professionalDetails.getHasThirdDegreeFriend());
		transformList(professionalDetails.getWentSameUniversityAs());
		transformList(professionalDetails.getWorkedInSameCompany());
		transformList(professionalDetails.getIsColleagueOf());
		transformList(professionalDetails.getIsFluentIn());
		transformList(professionalDetails.getHasBasicCommunicationSkillsIn());
		transformList(professionalDetails.getIsExpertIn());
		transformList(professionalDetails.getIsStillStudentAt());
		transformList(professionalDetails.getIsGraduated());
		
		System.out.println("Has Second Degree Friends : "+professionalDetails.getHasSecondDegreeFriend());
		System.out.println("Has Third Degree Friends : "+professionalDetails.getHasThirdDegreeFriend());
		System.out.println("Went Same University As : "+professionalDetails.getWentSameUniversityAs());
		System.out.println("Worked In Same Company : "+professionalDetails.getWorkedInSameCompany());
		System.out.println("Is Colleague Of : "+professionalDetails.getIsColleagueOf());
		System.out.println("Is Fluent In : "+professionalDetails.getIsFluentIn());
		System.out.println("Has Basic Communication Skills In : "+professionalDetails.getHasBasicCommunicationSkillsIn());
		System.out.println("Is Expert In : "+professionalDetails.getIsExpertIn());
		System.out.println("Is Still Student At : "+professionalDetails.getIsStillStudentAt());
		System.out.println("Is Graduated : "+professionalDetails.getIsGraduated());

	}

	public List<String> get_List_HasSecondDegreeFriend(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasSecondDegreeFriend ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public List<String> get_List_HasThirdDegreeFriend(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasThirdDegreeFriend ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public List<String> get_List_WentSameUniversityAs(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:wentSameUniversityAs ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public List<String> get_List_WorkedInSameCompany(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:workedInSameCompany ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public List<String> get_List_IsColleagueOf(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:isColleagueOf ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public List<String> get_List_IsFluentIn(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:isFluentIn ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public List<String> get_List_HasBasicCommunicationSkillsIn(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:hasBasicCommunicationSkillsIn ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public List<String> get_List_IsExpertIn(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:isExpertIn ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public List<String> get_List_IsStillStudentAt(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:isStillStudentAt ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public List<String> get_List_IsGraduated(String prof) {

		List<String> list = new ArrayList<String>();

		String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
		String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> " + "SELECT ?y " + "WHERE { "
				+ "?x lp:isGraduated ?y " + " FILTER (str(?x) = \"" + uri + "\" )" + " }";

		QueryProcess exec = QueryProcess.create(gr);

		Mappings map = null;

		try {
			map = exec.query(query);
		} catch (Exception e) {
		}

		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
		}

		return list;
	}

	public void transformList(List<String> listToTransform) {
		int i = 0;
		Iterator<String> iterator = listToTransform.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			int positionOfDiez = element.indexOf("#");
			listToTransform.set(i, element.substring(positionOfDiez + 1, element.length()));
			i++;
		}
	}

}
