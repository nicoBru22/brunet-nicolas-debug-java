package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {

		//lecture du document "symptom.txt" 
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			
			//compte le nombre de fois où le symptome "headache" est présent
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			//compte le nombre de fois où le symptome "rash" est présent
			else if (line.equals("rash")) {
				rashCount++;
			}
			//compte le nombre de fois où le symptome "pupils" est présent
			else if (line.contains("pupils")) {
				pupilCount++;
			}
			
			line = reader.readLine();
		}
		
		//Ecriture du résultat dans le fichier "result.out"
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
