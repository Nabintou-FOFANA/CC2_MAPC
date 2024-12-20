package org.example.rendu.metiers.impl.visiteurs;

import org.example.rendu.metiers.api.Visiteur;
import org.example.rendu.metiers.impl.structure.Difference;
import org.example.rendu.metiers.impl.structure.Ensemble;
import org.example.rendu.metiers.impl.structure.Selection;
import org.example.rendu.metiers.impl.structure.Union;

public class VisiteurCalcul implements Visiteur {
    @Override
    public int visiter(Ensemble ensemble) {
        return 1;
    }

    @Override
    public int visiter(Union union) {
        int cout = union.getSousRequetes().stream()
                .mapToInt(requete -> requete.accepter(this))
                .sum();
        return cout + union.getSousRequetes().size();
    }

    @Override
    public int visiter(Selection selection) {
        return 1 + selection.getSousRequetes().stream()
                .mapToInt(requete -> requete.accepter(this))
                .sum();
    }

    @Override
    public int visiter(Difference difference) {
        return 2 + difference.getSousRequetes().stream()
                .mapToInt(requete -> requete.accepter(this))
                .sum();
    }
}

