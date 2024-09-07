package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;



public class AnalyticsCounter {
	
	private ISymptomReader monReader;
    private ISymptomWriter monWriter;
    
	AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.monReader = reader;
		this.monWriter = writer;
	}
	
	public Map<String, Integer> symptomCount(List<String> symptoms) {
	    Map<String, Integer> symptomCounts = new HashMap<>();
	    for (String symptom : symptoms) {
	        symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
	    }
	    return symptomCounts;
	}
	
	public List<String> sortedSymptoms(Map<String, Integer> symptomCounts){
	    List<Map.Entry<String, Integer>> sortedSymptomEntries = new ArrayList<>(symptomCounts.entrySet());
	    Collections.sort(sortedSymptomEntries, Map.Entry.comparingByKey());
	    List<String> symptomData = sortedSymptomEntries.stream()
	            .map(entry -> entry.getKey() + ": " + entry.getValue())
	            .collect(Collectors.toList());
		return symptomData;
	}
	
	public void analyseEtEcritureSymptome() {
		
	    List<String> symptoms = monReader.GetSymptoms();
	    
	    Map<String, Integer> symptomCounts = symptomCount(symptoms);
	    
	    List<String> symptomData = sortedSymptoms(symptomCounts);

	    monWriter.WriteSymptomData(symptomData);
	}
	
}


