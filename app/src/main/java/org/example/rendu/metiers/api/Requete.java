package org.example.rendu.metiers.api;

// Interface principale du composite
import org.example.rendu.metiers.impl.structure.Personne;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Requete {
    List<Requete> getSousRequetes();

    int getProfondeur();

    Set<Personne> executer();

    int accepter(Visiteur visiteur);
}