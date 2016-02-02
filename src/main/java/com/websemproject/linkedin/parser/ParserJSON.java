package com.websemproject.linkedin.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.websemproject.linkedin.model.Professional;

public class ParserJSON {

	public Professional jsonToProfessional(String fileLocation) throws NullPointerException {
		Gson gson = new Gson();
		Professional professional = new Professional();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			professional = gson.fromJson(br, Professional.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return professional;
	}

}
