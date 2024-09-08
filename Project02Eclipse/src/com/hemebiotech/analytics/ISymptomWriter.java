package com.hemebiotech.analytics;

import java.util.List;

/**
 * Cette interface {@code ISymptomWriter} définit un contrat pour l'écriture des symptômes.
 * <p>
 * Les classes qui implémentent cette interface doivent fournir une méthode pour écrire les données
 * des symptômes dans une destination spécifique.
 * </p>
 */
public interface ISymptomWriter {

    /**
     * Écrit les données des symptômes dans un document spécifié.
     * <p>
     * Cette méthode doit être implémentée pour recevoir une liste de chaînes de caractères,
     * où chaque chaîne représente un symptôme et les écrire dans le document de sortie.
     * </p>
     *
     * @param result La liste des symptômes à écrire. Chaque élément de la liste est une chaîne de caractères
     *               représentant un symptôme à écrire dans le document.
     */
    void WriteSymptomData(List<String> result);
}
