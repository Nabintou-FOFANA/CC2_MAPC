package org.example.rendu.metiers.impl.structure;

import org.example.rendu.metiers.api.Requete;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Difference implements Requete {
    private final Requete requete1;
    private final Requete requete2;

    public Difference(Requete requete1, Requete requete2) {
        this.requete1 = requete1;
        this.requete2 = requete2;
    }

    @Override
    public List<Requete> getSousRequetes() {
        return List.of(requete1, requete2);
    }

    @Override
    public int getProfondeur() {
        return 1 + Math.max(requete1.getProfondeur(), requete2.getProfondeur());
    }

    @Override
    public Set<Personne> executer() {
        Set<Personne> resultat1 = new HashSet<>(requete1.executer());
        Set<Personne> resultat2 = requete2.executer();
        resultat1.removeAll(resultat2);
        return resultat1;
    }
}
