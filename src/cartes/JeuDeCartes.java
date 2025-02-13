package cartes;

import java.util.ArrayList;

public class JeuDeCartes {
	private List<Configuration> configurations = new ArrayList<>();
	
	
	private JeuDeCartes() {

	}
	
	public String affichageJeuDeCartes() {
		StringBuilder affichage = new StringBuilder("JEU :\n");
        for (Configuration config : configurations) {
            affichage.append(config.getNbExemplaires())
                     .append(config.getCarte().toString())
        }
        return affichage.toString();
	}

	private static class Configuration {
		
		private int nbExemplaire;
		private Carte carte;
		
		public Configuration(Carte carte, int nbExemplaire) {
			this.carte = carte;
			this.nbExemplaire = nbExemplaire;
		}

		private int getNbExemplaire() {
			return nbExemplaire;
		}

		private Carte getCarte() {
			return carte;
		}
	}
}
