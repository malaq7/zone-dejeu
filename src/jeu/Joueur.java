package jeu;
import cartes.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;


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
	public int hashCode() {
		return 31 * nom.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur) {
			return nom.equals(((Joueur) obj).getNom());
		}
		return false;
	}
	@Override
	public String toString() {
		return nom;
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
	
	
	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
		Set<Coup> coups = new HashSet<>();
		Iterator<Joueur> itJoueurCible = participants.iterator();
		
		while (itJoueurCible.hasNext()) {
			Joueur joueurCible = itJoueurCible.next();
			
			ListIterator<Carte> cartesIterateur = joueurCible.getMain().getListeCartes().listIterator();
			for (; cartesIterateur.hasNext();) {
				Carte carte = cartesIterateur.next();
				
				Coup coup = new Coup(this, joueurCible, carte);
				if (coup.estValide()) {
					coups.add(coup);
				}
			}
		}
		
		return coups;
	}
	

}
