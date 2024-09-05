package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteSymptomDataFromFile implements ISymptomWriter {

    @Override
    public void WriteSymptomData(int rashCount, int headacheCount, int pupilCount ) {
        String cheminFichier = "result.out";

        try  {
    		FileWriter writer = new FileWriter  (cheminFichier);
    		writer.write("headache: " + headacheCount + "\n");
    		writer.write("rash: " + rashCount + "\n");
    		writer.write("dialated pupils: " + pupilCount + "\n");
    		writer.close();
        } catch (IOException e) {
            System.err.println("Une erreur est survenue lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}
		
		
		
		

