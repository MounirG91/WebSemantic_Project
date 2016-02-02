package com.websemproject.linkedin.test;

import com.websemproject.linkedin.model.Professional;
import com.websemproject.linkedin.parser.ParserJSON;
import com.websemproject.linkedin.rdf.RDFManager;

public class RDFTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);
		
		String fileSource = workingDir + "\\attached_files";
		
		ParserJSON parser = new ParserJSON();
		Professional professional1 = new Professional();
		professional1 = parser.jsonToProfessional(fileSource+"\\YassineBenNaceurProfile.json");
		
		RDFManager rdfManager=new RDFManager();
		rdfManager.professionalToRDF(professional1); 
				
	}

}
