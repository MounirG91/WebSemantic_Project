package com.websemproject.linkedin.sparql;

import java.util.ArrayList;
import java.util.List;

import fr.inria.acacia.corese.api.IDatatype;
import fr.inria.acacia.corese.exceptions.EngineException;
import fr.inria.edelweiss.kgram.core.Mapping;
import fr.inria.edelweiss.kgram.core.Mappings;
import fr.inria.edelweiss.kgraph.core.*;
import fr.inria.edelweiss.kgraph.query.QueryProcess;
import fr.inria.edelweiss.kgraph.rule.RuleEngine;
import fr.inria.edelweiss.kgtool.load.Load;
import fr.inria.edelweiss.kgtool.load.LoadException;
import fr.inria.edelweiss.kgtool.print.ResultFormat; 


public class ManagerSparql {
	
	static Graph gr;

	public static void main(String[] args) {

		gr = Graph.create(true);
		
		Load ld = Load.create(gr); 
		 
		try {
		 ld.loadWE("./attached_files/linkedin.rdfs"); 
		 ld.loadWE("./attached_files/certifications.rdf");
		 ld.loadWE("./attached_files/universities.rdf");
		 ld.loadWE("./attached_files/skills.rdf");
		 ld.loadWE("./attached_files/linkedin.rul");
		 ld.loadWE("./attached_files/Achraf Aouadi.rdf"); 
		 ld.loadWE("./attached_files/Ahmed REBAI.rdf"); 
		 ld.loadWE("./attached_files/Amen Ouali.rdf"); 
		 ld.loadWE("./attached_files/Hela Tajouri.rdf"); 
		 ld.loadWE("./attached_files/Jomaa Farouk.rdf"); 
		 ld.loadWE("./attached_files/Khaled Ben Driss.rdf"); 
		 ld.loadWE("./attached_files/Mounir Guizani.rdf"); 
		 ld.loadWE("./attached_files/Ramzi Zayene.rdf"); 
		 ld.loadWE("./attached_files/Syrine Tlili, PhD.rdf"); 
		 ld.loadWE("./attached_files/Yassin Ben Naceur.rdf"); 
		}
		catch (LoadException e){} 

		RuleEngine re = ld.getRuleEngine();
		re.process();  
		gr.addEngine(re);
		gr.process();
		
			
		System.out.println(get_List_HasSecondDegreeFriend ("Yassin Ben Naceur"));
		System.out.println(get_List_HasThirdDegreeFriend ("Yassin Ben Naceur"));
		System.out.println(get_List_WentSameUniversityAs ("Yassin Ben Naceur"));
		System.out.println(get_List_WorkedInSameCompany ("Yassin Ben Naceur"));
		System.out.println(get_List_IsColleagueOf ("Yassin Ben Naceur"));
		System.out.println(get_List_IsFluentIn ("Yassin Ben Naceur"));
		System.out.println(get_List_HasBasicCommunicationSkillsIn ("Yassin Ben Naceur"));
		System.out.println(get_List_IsExpertIn ("Yassin Ben Naceur"));
		System.out.println(get_List_IsStillStudentAt ("Yassin Ben Naceur"));
		System.out.println(get_List_IsGraduated ("Yassin Ben Naceur"));

		
		
	}

public static List get_List_HasSecondDegreeFriend (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:hasSecondDegreeFriend ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}


public static List get_List_HasThirdDegreeFriend (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:hasThirdDegreeFriend ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}


public static List get_List_WentSameUniversityAs (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:wentSameUniversityAs ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}


public static List get_List_WorkedInSameCompany (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:workedInSameCompany ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}

public static List get_List_IsColleagueOf (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:isColleagueOf ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}

public static List get_List_IsFluentIn (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:isFluentIn ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}


public static List get_List_HasBasicCommunicationSkillsIn (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:hasBasicCommunicationSkillsIn ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}

public static List get_List_IsExpertIn (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:isExpertIn ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}


public static List get_List_IsStillStudentAt (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:isStillStudentAt ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}

public static List get_List_IsGraduated (String  prof ) {

	List list = new ArrayList ();

	String uri = "http://linkedin_project.com/profile.rdfs-instances/Professional/#" + prof;
	String query = "PREFIX lp: <http://linkedin_project.com/profile.rdfs#> "+ 
                    "SELECT ?y "+ 
                    "WHERE { " +
                    "?x lp:isGraduated ?y "+
                    " FILTER (str(?x) = \""+ uri + "\" )"+ 
                    " }" ; 

	QueryProcess exec = QueryProcess.create(gr); 
	 
	 
		Mappings map = null;
	
		try {
			map = exec.query(query);
		}
		catch (EngineException e){} 


		for (Mapping m : map) {
			IDatatype dt = (IDatatype) m.getValue("?y");
			list.add(dt.stringValue());
			}

	return list;
}

}
