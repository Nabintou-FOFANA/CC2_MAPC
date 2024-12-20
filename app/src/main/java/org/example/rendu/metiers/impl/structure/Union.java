package org.example.rendu.metiers.impl.structure;

import org.example.rendu.metiers.api.Requete;
import org.example.rendu.metiers.api.Visiteur;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Union implements Requete {
    private final List<Requete> sousRequetes;

    public Union(List<Requete> sousRequetes) {
        if (sousRequetes == null || sousRequetes.size() < 2) {
            throw new IllegalArgumentException("Une union doit contenir au moins deux sous-requêtes.");
        }
        this.sousRequetes = sousRequetes;
    }

    @Override
    public List<Requete> getSousRequetes() {
        return sousRequetes;
    }

    @Override
    public int getProfondeur() {
        return 1 + sousRequetes.stream().mapToInt(Requete::getProfondeur).max().orElse(0);
    }

    @Override
    public Set<Personne> executer() {
        return sousRequetes.stream()
                .flatMap(requete -> requete.executer().stream())
                .collect(Collectors.toSet());
    }

    @Override
    public int accepter(Visiteur visiteur) {
        return visiteur.visiter(this);
    }
}
