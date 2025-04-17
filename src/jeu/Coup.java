package jeu;

import cartes.*;

public class Coup {
	
	private Joueur joueurCourant;
	private Joueur joueurCible;
	private Carte carteJouee;
	
	public Coup(Joueur joueurCourant, Carte carteJouee, Joueur joueurCible) {
		this.joueurCourant = joueurCourant;
		this.joueurCible = joueurCible;
		this.carteJouee = carteJouee;
	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}

	public Carte getCarteJouee() {
		return carteJouee;
	}
	
	public boolean estValide() {
		if(joueurCourant != null)
			if (carteJouee instanceof Attaque || carteJouee instanceof DebutLimite) {
				return !joueurCourant.equals(joueurCible);
			} else {
				return  joueurCourant.equals(joueurCible);
			}
		else return false;
	}
	
	
	@Override
	public int hashCode() {
		return 31 * joueurCourant.hashCode() * (joueurCible == null ? 31 : joueurCible.hashCode()) * carteJouee.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
}
