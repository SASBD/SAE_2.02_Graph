package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GraphHHAdjTest {

    @Test
    void testAjoutSommetEtArc() {
        VarGraph graphe = new GrapheHHAdj();

        // Ajouter des sommets et des arcs
        graphe.ajouterArc("A", "B", 5);
        graphe.ajouterArc("A", "C", 10);
        graphe.ajouterArc("B", "C", 2);

        // Vérifier les successeurs
        List<Graph.Arc<String>> succA = graphe.getSucc("A");
        assertEquals(2, succA.size(), "Le sommet A doit avoir deux successeurs");

        List<Graph.Arc<String>> succB = graphe.getSucc("B");
        assertEquals(1, succB.size(), "Le sommet B doit avoir un successeur");

        List<Graph.Arc<String>> succC = graphe.getSucc("C");
        assertEquals(0, succC.size(), "Le sommet C ne doit pas avoir de successeurs");
    }

    @Test
    void testAjoutArcExistants() {
        VarGraph graphe = new GrapheHHAdj();

        // Ajouter des sommets et des arcs
        graphe.ajouterArc("A", "B", 5);

        // Tester si l'arc existe déjà et doit lancer une exception
        assertThrows(IllegalArgumentException.class, () -> {
            graphe.ajouterArc("A", "B", 10); // Arc déjà présent
        }, "Une exception doit être lancée si l'arc existe déjà");
    }

    @Test
    void testPeupler() {
        String description = "A-B(5), A-C(10), B-C(3), C-D(8)";
        VarGraph graphe = new GrapheHHAdj();

        // Peupler le graphe à partir d'une chaîne de caractères
        graphe.peupler(description);

        // Vérifier les successeurs
        List<Graph.Arc<String>> succA = graphe.getSucc("A");
        assertEquals(2, succA.size(), "Le sommet A doit avoir deux successeurs");

        List<Graph.Arc<String>> succB = graphe.getSucc("B");
        assertEquals(1, succB.size(), "Le sommet B doit avoir un successeur");

        List<Graph.Arc<String>> succC = graphe.getSucc("C");
        assertEquals(1, succC.size(), "Le sommet C doit avoir un successeur");

        List<Graph.Arc<String>> succD = graphe.getSucc("D");
        assertEquals(0, succD.size(), "Le sommet D ne doit pas avoir de successeur");
    }
}
