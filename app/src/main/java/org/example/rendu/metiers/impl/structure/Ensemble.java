package org.example.rendu.metiers.impl.structure;

import org.example.rendu.metiers.api.Requete;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Ensemble implements Requete {
    private final Set<Personne> personnes;

    public Ensemble(Set<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public List<Requete> getSousRequetes() {
        return Collections.emptyList();
    }

    @Override
    public int getProfondeur() {
        return 1;
    }

    @Override
    public Set<Personne> executer() {
        return personnes;
    }
}
