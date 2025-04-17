package jeu;

import cartes.*;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

import utils.*;

public class Jeu {
	private Sabot sabot;
	private List<Carte> listeCartes;
	private Set<Joueur> joueurs = new LinkedHashSet<>();

	public Jeu(Carte[] cartes) {
		listeCartes = new ArrayList<>();
		listeCartes.addAll(Arrays.asList(cartes));
		listeCartes = GestionCartes.melanger(listeCartes);
		sabot = new Sabot(listeCartes.toArray(new Carte[0]));
	}

}