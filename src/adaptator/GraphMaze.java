package adaptator;

import graph.Graph;
import maze.Maze;

import java.util.ArrayList;
import java.util.List;

public class GraphMaze<C> implements Graph<C> {

    private final Maze<C> maze;
    // on definit le labyrinthe Maze avec les cellules C
    public GraphMaze(Maze<C> maze) {
        this.maze = maze;
    }

    // On cree des arcs avec les voisins sans murs de poids 1.
    // On calcule donc le chemin le plus court dans un labyrinthe avec Dijkstra
    @Override
    public List<Graph.Arc<C>> getSucc(C sommet) {
        List<Graph.Arc<C>> succ = new ArrayList<>();
        for (C voisin : maze.openedNeighbours(sommet)) {
            succ.add(new Graph.Arc<C>(1, voisin));
        }
        return succ;
    }
}