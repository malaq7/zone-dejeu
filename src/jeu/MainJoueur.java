package jeu;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur {
	
	private List<Carte> main = new ArrayList<>();

	public MainJoueur() {
		/* TODO document why this constructor is empty */
		// TODO
		}
	
	public void prendre(Carte carte) {
		main.add(carte);
	}
	
	public void jouer(Carte carte) {
		if( main.contains(carte)) {
			main.remove(carte ); 
		}
	}
	

	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("[");
		for (ListIterator<Carte> iter =main.listIterator() ; iter.hasNext() ;) {
				string.append(main.get(iter.nextIndex()- 1 ).toString());
		}
		string.append("]\n");
		return string.toString();
	}
	
	public List<Carte> getListeCartes() {
		return main;
	}
}