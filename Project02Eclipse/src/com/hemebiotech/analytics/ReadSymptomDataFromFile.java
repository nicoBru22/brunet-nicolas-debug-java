package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La class {@code ReadSymptomDataFromFile} permet de lire un fichier composé de symptom.
 * Cette class implémente l'interface {@link ISymptomReader}.
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * Le constructeur {@code ReadSymptomDataFromFIle()} initialise le chemin d'accès à la ressource.
	 * 
	 * @param filepath est le chemin d'accès à la ressource où se situe les symptomes
	 */
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * La méthode {@code GetSymptoms()} permet de créer une liste nommée {@code result}.
	 * Cette méthode permet de lire ligne par ligne un fichier et les ajoute à une liste.
	 * Si le fichier n'existe pas, une erreur s'affiche dans la console. 
	 * 
	 * @return result, est une liste de caractère où chaque ligne est un symptome
	 * @throws si le fichier n'existe pas, une liste vide est retournée
	 */

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
	            System.err.println("Une erreur est survenue lors de la lecture du fichier : " + e.getMessage());
	        }
		}
		
		return result;
	}

}
