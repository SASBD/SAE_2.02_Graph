package Djikstra;

import graph.*;

import java.util.*;

public class Dijkstra<T> implements ShortestPath<T> {

	@Override
	public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) throws IllegalArgumentException {
		Map<T, Integer> distance = new HashMap<>();
		Map<T, T> pred = new HashMap<>();
		Set<T> vus = new HashSet<>();

		PriorityQueue<T> file = new PriorityQueue<>(Comparator.comparingInt(distance::get));

		distance.put(src, 0);
		pred.put(src, null);
		file.add(src);

		while (!file.isEmpty()) {
			T courant = file.poll();

			if (vus.contains(courant)) continue;
			vus.add(courant);


			List<Graph.Arc<T>> successeurs = g.getSucc(courant);
			for (int i = 0; i < successeurs.size(); i++) {
				Graph.Arc<T> arc = successeurs.get(i);
				T voisin = arc.dst();
				int poids = arc.val();

				if (poids < 0) {
					throw new IllegalArgumentException("Le graphe contient un arc de poids négatif.");
				}

				int nouvelleDistance = distance.get(courant) + poids;

				if (!distance.containsKey(voisin) || nouvelleDistance < distance.get(voisin)) {
					distance.put(voisin, nouvelleDistance);
					pred.put(voisin, courant);
					file.add(voisin);
				}
			}
		}

		return new Distances<>(distance, pred);
	}
}
