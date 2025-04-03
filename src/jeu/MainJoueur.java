package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainJoueur {
	
	private List<Carte> main = new ArrayList<>();

	public MainJoueur() {
		
	}
	
	public void prendre(Carte e) {
		main.add(e);
	}
	
	public void jouer(Carte e) {
		assert main.contains(e);
		main.remove(e);
	}
	

	
	@Override
	public String toString() {
		int nbCartes = main.size();
		StringBuilder string = new StringBuilder("[");
		
		for (int i = 0; i < nbCartes; i++) {
			if (i < nbCartes - 1)
				string.append(main.get(i).toString() + ", ");
			else
				string.append(main.get(i).toString());
		}
		string.append("]\n");
		return string.toString();
	}
}