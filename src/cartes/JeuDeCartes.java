package cartes;

public class JeuDeCartes {

	private Configuration[] typesDeCartes = new Configuration[] { new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12), new Configuration(new Borne(200), 4),
			new Configuration(new DebutLimite(), 4), new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.FEU), 14), new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6), new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new Attaque(Type.FEU), 5), new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Botte(Type.FEU), 1), new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ACCIDENT), 1) };

	public String affichageJeuCartes() {
		StringBuilder string = new StringBuilder();
		for (Configuration config : typesDeCartes) {
			string.append(config.getNbExemplaires() + " " + config.getCarte().toString() + "\n");
		}
		return string.toString();
	}

	private int getCount() {
		int count = 0;
		for (Configuration config : typesDeCartes) {
			count += config.getNbExemplaires();
		}
		return count;
	}

	public Carte[] donnerCartes() {
        Carte[] cartes = new Carte[getCount()];

        for (int i = 0, j = 0; j < 19; j++) {
            Configuration config = typesDeCartes[j];
            for (int numCarte = 0; numCarte < config.getNbExemplaires(); numCarte++) {
                cartes[i++] = config.getCarte();
            }
        }
        return cartes;
    }
	

    
	public boolean checkCount() {
	    Carte[] cartes = donnerCartes();  
	    for (int i = 0; i < 19; i++) {  
	        Carte c = typesDeCartes[i].getCarte(); 
	        int expectedCount = typesDeCartes[i].getNbExemplaires(); 
	        	        int actualCount = 0;
	        for (int j = 0; j < cartes.length; j++) {
	            if (cartes[j].equals(c)) {
	                actualCount++;
	            }
	        }
	        if (expectedCount != actualCount) {
	            return false;
	        }
	    }
	    return true;
	}

	private static class Configuration {

		private int nbExemplaires;
		private Carte carte;

		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

	}
}
