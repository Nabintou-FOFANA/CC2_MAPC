package org.example.rendu.metiers.api;

import org.example.rendu.metiers.impl.structure.Personne;

import java.util.List;
import java.util.Set;

public interface Requete {
    List<Requete> getSousRequetes();

    int getProfondeur();

    Set<Personne> executer();
}
