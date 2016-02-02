package com.websemproject.linkedin.test;

import com.websemproject.linkedin.model.Professional;
import com.websemproject.linkedin.parser.ParserXML;

public class ParserTest {
	public static void main(String[] args) {

		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);

		String fileSource = workingDir + "\\attached_files";

		ParserXML parser = new ParserXML();

		Professional professional = parser.fromRdfFileToProfessional(fileSource,
				"Jomaa Farouk");

		professional.displayProfessional(professional);
		
	}

}
