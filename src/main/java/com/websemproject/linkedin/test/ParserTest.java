package com.websemproject.linkedin.test;

import com.websemproject.linkedin.model.Professional;
import com.websemproject.linkedin.parser.ParserRDF;

public class ParserTest {
	public static void main(String[] args) {

		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);

		String fileSource = workingDir + "\\attached_files";

		ParserRDF parser = new ParserRDF();

		Professional professional = parser.fromRdfFileToProfessional(fileSource,
				"Mounir Guizani");

		professional.displayProfessional(professional);
		
	}

}
