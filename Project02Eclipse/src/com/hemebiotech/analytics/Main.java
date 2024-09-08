package com.hemebiotech.analytics;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * La classe {@code Main} est le point d'entrée de l'application.
 * <p>
 * Elle crée des instances des classes {@link ReadSymptomDataFromFile} et {@link WriteSymptomDataFromFile}
 * pour lire les symptômes à partir d'un fichier et écrire les résultats dans un autre fichier.
 * Ensuite, elle utilise un objet {@link AnalyticsCounter} pour analyser les symptômes et produire un rapport.
 * </p>
 */
public class Main {
    
    /**
     * Le point d'entrée de l'application.
     * <p>
     * Cette méthode configure les objets nécessaires pour lire les symptômes depuis un fichier,
     * analyser les données et écrire les résultats dans un fichier de sortie.
     * </p>
     *
     * @param args Les arguments de ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {
        
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        
        ISymptomWriter writer = new WriteSymptomDataFromFile("result.out");
        
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        analyticsCounter.analyticsSymptoms();
    }
}
