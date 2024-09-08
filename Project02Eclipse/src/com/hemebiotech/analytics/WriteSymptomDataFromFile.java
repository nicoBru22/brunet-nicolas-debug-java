package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * La class {@code WriteSymptomDataFromFile} permet d'écrire des données sur les symptômes
 * dans un fichier spécifié par le chemin {@code filePath}.
 * Cette class implémente l'interface {@link ISymptomWriter} et fournit une implémentation de la méthode
 * {@code WriteSymptomData} pour écrire une liste de symptômes dans un fichier.
 */
public class WriteSymptomDataFromFile implements ISymptomWriter {

	private String filePath;

	/**
	 * Le constructeur {@code WriteSymptomDataFromFile} initialise la class avec le chemin du fichier
	 * dans lequel les données seront écrites.
	 * 
	 * @param filePath Le chemin d'accès où le fichier sera créé ou ouvert pour écriture.
	 */
	public WriteSymptomDataFromFile(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * La méthode {@code WriteSymptomData} écrit les informations sur les symptômes dans le fichier spécifié.
	 * Cette méthode prend une liste de chaînes de caractères, où chaque élément représente un symptôme, 
	 * et les écrit ligne par ligne dans le fichier. 
	 * Si une erreur survient lors de l'écriture, un message d'erreur est affiché dans la console.
	 *
	 * @param result La liste des symptômes à écrire dans le fichier. Ce paramètre est le retour de la méthode {@link analyseEtEcritureSymptome()}
	 * de la class {@link AnalyticsCounter}
	 * @throws IOException Si une erreur survient lors de l'écriture dans le fichier, une exception {@code IOException} est levée.
	 */
    public void WriteSymptomData(List<String> result) {

        try {
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
