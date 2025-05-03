package graph;

import java.util.*;

public class VarGraphMethod extends GraphMethod<String> implements VarGraph {

    // Ajoute un sommet vide (sans successeurs)
    @Override
    public void ajouterSommet(String noeud) {
        adj.putIfAbsent(noeud, new ArrayList<>());
    }

    // Ajoute un arc entre deux sommets, crée les sommets s’ils n’existent pas
    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        ajouterSommet(source);      // On s’assure que le sommet source existe
        ajouterSommet(destination); // On s'assure que le sommet destination existe

        List<Arc<String>> succ = getSucc(source); // On cree une liste contenant les successeurs du sommet source

        // Vérifie si l'arc existe déjà grace a une boucle for each
        for (Arc<String> arc : succ) {
            if (arc.dst().equals(destination)) {
                throw new IllegalArgumentException("Arc déjà présent entre " + source + " et " + destination);
            }
        }

        succ.add(new Arc<>(valeur, destination));
    }
}