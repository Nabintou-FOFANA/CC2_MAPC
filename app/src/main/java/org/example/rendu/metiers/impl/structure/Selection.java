package org.example.rendu.metiers.impl.structure;

import org.example.rendu.metiers.api.Requete;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Selection implements Requete {
    private final Requete sousRequete;
    private final Predicate<Personne> predicate;

    public Selection(Requete sousRequete, Predicate<Personne> predicate) {
        this.sousRequete = sousRequete;
        this.predicate = predicate;
    }

    @Override
    public List<Requete> getSousRequetes() {
        return List.of(sousRequete);
    }

    @Override
    public int getProfondeur() {
        return 1 + sousRequete.getProfondeur();
    }

    @Override
    public Set<Personne> executer() {
        return sousRequete.executer().stream()
                .filter(predicate)
                .collect(Collectors.toSet());
    }
}

