package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteSymptomDataFromFile implements ISymptomWriter {

	private String filePath;
	
	public WriteSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	
    public void WriteSymptomData(List<String> result) {

        try  {
    		FileWriter fileWriter = new FileWriter(filePath);
    		BufferedWriter writer = new BufferedWriter(fileWriter);
    		
    		for (String symptom : result) {
    			writer.write(symptom);
    			writer.newLine();
    		}
    		writer.close();
        } catch (IOException e) {
            System.err.println("Une erreur est survenue lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}
		
		
		
		

