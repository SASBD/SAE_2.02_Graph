# 📐 SAE Java & Graphe : Dijkstra & Labyrinthe

## 🧠 Description

Ce projet est structuré en **deux parties** :

### 🔢 Partie I – Création de l’algorithme de Dijkstra
Implémentation de l’algorithme de Dijkstra pour :
- Trouver le chemin le plus court entre deux sommets donnés,
- De calculer les plus courts chemins depuis un sommet source vers tous les sommets accessibles.

Une exception (`IllegalArgumentException`) est levée si un arc de poids négatif est accessible depuis le sommet de départ.

### 🧩 Partie II – Application à un labyrinthe
Application de l’algorithme sur un **labyrinthe non orienté et non pondéré** :
- Adaptation du labyrinthe sous forme de graphe via un adaptateur `GraphMaze`,
- Animation graphique de l’algorithme sur le labyrinthe.

---

## 👥 Contributeurs
- Projet en équipe de 3 personnes

- 👤 Sofiane B.
- 👤 Nguyen P.
- 👤 Lyna T.
Groupe 103

---

## 📌 Remarques

- L’interface `Animator` est utilisée uniquement pour l’animation graphique.
- Multiples tests réalisés avec le fichier `Djikstra.DijkstraTest.java` ainsi que des tests personnels.

---

## 📎 Liens utiles

- 🔗 [Djikstra](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)
- 🔗 [Dépôt GitHub](https://github.com/SASBD/SAE_2.02_Graph)
