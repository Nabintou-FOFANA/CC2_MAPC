package org.example.rendu.client;

import org.example.rendu.metiers.impl.structure.Ensemble;
import org.example.rendu.metiers.impl.structure.Personne;
import org.example.rendu.metiers.impl.structure.Selection;
import org.example.rendu.metiers.impl.structure.Union;
import org.example.rendu.metiers.impl.visiteurs.VisiteurCalcul;

import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Set<Personne> personnes = Set.of(
                new Personne("alice", 20, 2000),
                new Personne("bob", 17, 100),
                new Personne("charles", 17, 2600),
                new Personne("david", 70, 1000),
                new Personne("elisabeth", 72, 900)
        );

        Ensemble base = new Ensemble(personnes);


        Selection mineurs = new Selection(base, p -> p.getAge() < 18);
        Selection retraites = new Selection(base, p -> p.getAge() > 64);

        Selection mineursRiches = new Selection(mineurs, p -> p.getSalaire() > 2500);
        Selection retraitesPauvres = new Selection(retraites, p -> p.getSalaire() < 1000);

        Union outliers = new Union(List.of(mineursRiches, retraitesPauvres));

        VisiteurCalcul visiteur = new VisiteurCalcul();

        System.out.println(base.executer() + "(" + base.getProfondeur() + ")");
        System.out.println(base.accepter(visiteur));

        System.out.println(mineurs.executer() + "(" + mineurs.getProfondeur() + ")");
        System.out.println(mineurs.accepter(visiteur));

        System.out.println(retraites.executer() + "(" + retraites.getProfondeur() + ")");
        System.out.println(retraites.accepter(visiteur));

        System.out.println(mineursRiches.executer() + "(" + mineursRiches.getProfondeur() + ")");
        System.out.println(mineursRiches.accepter(visiteur));

        System.out.println(retraitesPauvres.executer() + "(" + retraitesPauvres.getProfondeur() + ")");
        System.out.println(retraitesPauvres.accepter(visiteur));

        System.out.println(outliers.executer() + "(" + outliers.getProfondeur() + ")");
        System.out.println(outliers.accepter(visiteur));
    }

}
