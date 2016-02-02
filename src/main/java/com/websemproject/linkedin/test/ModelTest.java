package com.websemproject.linkedin.test;

import java.io.IOException;
import java.text.ParseException;

import com.websemproject.linkedin.model.Professional;
import com.websemproject.linkedin.parser.ParserJSON;


public class ModelTest {
	public static void main(String[] args) throws NullPointerException, ParseException, IOException {
		
		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);
		
		String fileSource = workingDir + "\\attached_files";
		
		ParserJSON parser = new ParserJSON();
		Professional professional = new Professional();
		professional = parser.jsonToProfessional(fileSource+"\\YassineBenNaceurProfile.json");
		professional.displayProfessional(professional);


	}
}
