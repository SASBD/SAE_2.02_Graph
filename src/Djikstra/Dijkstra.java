package Djikstra;

import graph.*;

import java.util.*;

public class Dijkstra<T> implements ShortestPath<T> {

	@Override
	public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) throws IllegalArgumentException {
		// initialisation des donnees
		// Distance : (sommet,distance min)
		// Predecesseur : (sommet, sommet)
		// Vus : liste unique des sommets
		Map<T, Integer> distance = new HashMap<>();
		Map<T, T> pred = new HashMap<>();
		Set<T> vus = new HashSet<>();

		// iniatialisation de la queue, trie en ordre croissant les distances
		PriorityQueue<T> file = new PriorityQueue<>(Comparator.comparingInt(distance::get));

		// initialisation des valeurs pour le sommet de depart
		// pas de predecesseur et distance a 0 (lui meme)
		// premier dans la queue
		distance.put(src, 0);
		pred.put(src, null);
		file.add(src);

		// Boucle de l'algo : traite tout les sommets non visites
		while (!file.isEmpty()) {
			// retourne le sommet avec l'arc la dist la plus petite
			T courant = file.poll();

			if (vus.contains(courant)) continue;
			vus.add(courant);
			
			animator.accept(courant, distance.get(courant));

			List<Graph.Arc<T>> successeurs = g.getSucc(courant);

			// boucle qui calcule les distances des successeurs
			for (int i = 0; i < successeurs.size(); i++) {
				// extractiom des valeurs des sommets voisins dans la boucle
				Graph.Arc<T> arc = successeurs.get(i);
				T voisin = arc.dst();
				int poids = arc.val();

				if (poids < 0) {
					throw new IllegalArgumentException("Le graphe contient un arc de poids négatif.");
				}

				int nouvelleDistance = distance.get(courant) + poids;

				// MAJ de la distance/pred du sommet voisin si plus court ou nouveau
				if (!distance.containsKey(voisin) || nouvelleDistance < distance.get(voisin)) {
					distance.put(voisin, nouvelleDistance);
					pred.put(voisin, courant);
					file.add(voisin); // On met a jour la queue
				}
			}
		}

		return new Distances<>(distance, pred);
	}
}
