package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;

/**
 * La classe {@code AnalyticsCounter} est responsable de la lecture, du comptage, du tri et de l'écriture des symptômes.
 * <p>
 * Elle utilise des objets {@link ISymptomReader} pour lire les symptômes et {@link ISymptomWriter} pour écrire les résultats.
 * Les symptômes sont comptés, triés par ordre alphabétique, et les résultats sont écrits dans un document spécifié.
 * </p>
 */
public class AnalyticsCounter {
    
    private ISymptomReader monReader;
    private ISymptomWriter monWriter;
    
    /**
     * Le constructeur {@code AnalyticsCounter} initialise un objet avec les interfaces {@link ISymptomReader} et {@link ISymptomWriter}.
     * 
     * @param reader Une instance de {@link ISymptomReader} utilisée pour lire les symptômes.
     * @param writer Une instance de {@link ISymptomWriter} utilisée pour écrire les résultats.
     */
    AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.monReader = reader;
        this.monWriter = writer;
    }
    
    /**
     * La méthode {@code symptomCount} compte le nombre d'occurrences de chaque symptôme dans une liste.
     * <p>
     * Elle crée une {@code Map} où les clés sont les symptômes et les valeurs sont le nombre d'occurrences.
     * </p>
     * 
     * @param symptoms Une liste de symptômes, où chaque élément représente un symptôme.
     * @return Une {@code Map} où les clés sont les symptômes et les valeurs sont leur nombre d'occurrences.
     */
    public Map<String, Integer> symptomCount(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();
        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }
    
    /**
     * La méthode {@code sortedSymptoms} trie les symptômes par ordre alphabétique.
     * <p>
     * Elle utilise la {@code Map} obtenue de {@link symptomCount} pour créer une liste de chaînes de caractères
     * où chaque élément est un symptôme suivi de son nombre d'occurrences, triés par ordre alphabétique des symptômes.
     * </p>
     * 
     * @param symptomCounts Une {@code Map} où les clés sont les symptômes et les valeurs sont leur nombre d'occurrences.
     * @return Une liste de chaînes de caractères où chaque élément est un symptôme suivi de son nombre d'occurrences, triés par ordre alphabétique.
     */
    public List<String> sortedSymptoms(Map<String, Integer> symptomCounts) {
        List<Map.Entry<String, Integer>> sortedSymptomEntries = new ArrayList<>(symptomCounts.entrySet());
        Collections.sort(sortedSymptomEntries, Map.Entry.comparingByKey());
        return sortedSymptomEntries.stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.toList());
    }
    
    /**
     * La méthode {@code analyseEtEcritureSymptome} coordonne la lecture, le comptage, le tri et l'écriture des symptômes.
     * <p>
     * Elle appelle les méthodes {@link GetSymptoms()}, {@link symptomCount()}, {@link sortedSymptoms()} et {@link WriteSymptomData()}
     * pour lire les symptômes, les compter, les trier, et écrire les résultats dans un fichier spécifié.
     * </p>
     */
    public void analyseEtEcritureSymptome() {
        List<String> symptoms = monReader.GetSymptoms();
        Map<String, Integer> symptomCounts = symptomCount(symptoms);
        List<String> symptomData = sortedSymptoms(symptomCounts);
        monWriter.WriteSymptomData(symptomData);
    }
}
