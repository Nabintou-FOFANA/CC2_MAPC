package org.example.rendu.metiers.api;

import org.example.rendu.metiers.impl.structure.Difference;
import org.example.rendu.metiers.impl.structure.Ensemble;
import org.example.rendu.metiers.impl.structure.Selection;
import org.example.rendu.metiers.impl.structure.Union;

public interface Visiteur {
    int visiter(Ensemble ensemble);

    int visiter(Union union);

    int visiter(Selection selection);

    int visiter(Difference difference);
}

