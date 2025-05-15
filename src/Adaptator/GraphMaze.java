package Adaptator;

import graph.Graph;
import maze.Maze;

import java.util.ArrayList;
import java.util.List;

public class GraphMaze<C> implements Graph<C> {

    private final Maze<C> maze;

    public GraphMaze(Maze<C> maze) {
        this.maze = maze;
    }

    @Override
    public List<Graph.Arc<C>> getSucc(C sommet) {
        List<Graph.Arc<C>> succ = new ArrayList<>();
        for (C voisin : maze.openedNeighbours(sommet)) {
            succ.add(new Graph.Arc<C>(1, voisin));
        }
        return succ;
    }
}