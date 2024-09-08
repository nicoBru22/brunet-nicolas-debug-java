package com.hemebiotech.analytics;

import java.util.List;

/**
 * Cette interface {@code ISymptomReader} définit un contrat pour la lecture des symptômes.
 * Les class qui implémentent cette interface doivent fournir une méthode pour récupérer
 * une liste de symptômes à partir d'une source de données spécifique.
 */
public interface ISymptomReader {
    
    /**
     * Récupère la liste des symptômes à partir de la source de données.
     * Les symptômes sont retournés sous forme de liste de chaînes de caractères,
     * où chaque chaîne représente un symptôme individuel.
     *
     * @return Une liste de chaînes de caractères représentant les symptômes.
     */
    List<String> getSymptoms();
}

