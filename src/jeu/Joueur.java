package jeu;
import cartes.*;

public class Joueur {
	
	private String nom;
	private ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
	private MainJoueur main = new MainJoueur();

	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur other) {
			return nom.equals(other.getNom());
		}
		return false;
	}
	
	public MainJoueur getMain() {
		return main;
	}
	
	public void donner(Carte c) {
		main.prendre(c);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if (sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		donner(carte);
		return carte;
	}
	public void deposer(Carte c) {
		zoneDeJeu.deposer(c);
	}
	public boolean estDepotAutorise(Carte carte) {
		return zoneDeJeu.estDepotAutorise(carte);
	}
	

}
