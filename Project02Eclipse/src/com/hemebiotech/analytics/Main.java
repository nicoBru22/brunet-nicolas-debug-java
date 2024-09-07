package com.hemebiotech.analytics;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    	
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        
        ISymptomWriter writer = new WriteSymptomDataFromFile("result.out");
        
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        analyticsCounter.analyseEtEcritureSymptome();
    }
}