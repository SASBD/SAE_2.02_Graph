package Djikstra;

import graph.*;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra<T> implements ShortestPath<T> {

	private final Map<T, Integer> distance = new HashMap<>();
	private final Map<T, T> pred = new HashMap<>();
	private final Map<T, Boolean> visited = new HashMap();


	@Override
	public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) throws IllegalArgumentException {
		distance.put(src, 0); // La distance du sommet source est 0

		// Initialisation des distances à l'infini et prédécesseurs à null
		if (!(g instanceof GraphMethod<T> graphMethod)) {
			throw new IllegalArgumentException("Graphe incompatible");
		}

// Initialisation
		for (T sommet : graphMethod.getSommet()) {
			distance.put(sommet, Integer.MAX_VALUE);
			pred.put(sommet, null);
			visited.put(sommet, false);
		}
		distance.put(src, 0);

		return new Distances<>(distance, pred); }

}
