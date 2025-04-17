package jeu;
import cartes.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;


public class ZoneDeJeu {
	
	private List<Limite> pileLimites = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private Collection<Borne> pileBorne = new ArrayList<>();
//ensemble\
	private Set<Botte> bottes = new HashSet<>();

	

	public List<Limite> getLimites() {
		return pileLimites;
	}
	
	public List<Bataille> getBataille() {
		return pileBataille;
	}
	
	public Set<Botte> getBottes() {
		return bottes;
	}
	
	public boolean estPrioritaire() {
		return bottes.contains(Cartes.PRIORITAIRE);
	}
	

	 public int donnerLimitationVitesse() {
	        if (pileLimites.isEmpty() || 
	            (donnerSommet(pileLimites) instanceof FinLimite) || 
	            estPrioritaire()) {
	            return 200;
	        }
	        return 50;
	}
	 
	 public int donnerKmParcourus() {
		 int total = 0;
		 Iterator<Borne> it = pileBorne.iterator();
		    while (it.hasNext()) {
		        total += it.next().getKm();
		    }
		    return total;
		}
	 
	public <E> E donnerSommet(List<E> pile) {
	    return pile.isEmpty() ? null : pile.get(pile.size() - 1);
	}
	
	
	
	public boolean peutAvancer() {
		if (pileBataille.isEmpty() && estPrioritaire()) {
			return true;
		} else if (!pileBataille.isEmpty()) {
			Bataille c = donnerSommet(pileBataille);
			return (c.equals(Cartes.FEU_VERT) 
					|| ((c instanceof Parade) && estPrioritaire()) 
					|| ((c instanceof Attaque) && c.equals(Cartes.FEU_ROUGE) && estPrioritaire())
					|| ((c instanceof Attaque) && !c.equals(Cartes.FEU_ROUGE) &&
							bottes.contains(new Botte(c.getType())) && estPrioritaire()));
		}
		return false;
	}
	
	private boolean estDepotFeuVertAutorise() {
		if (pileBataille.isEmpty()) {
			return true;
		} else {
			Bataille sommet = donnerSommet(pileBataille);
			return sommet.equals(Cartes.FEU_ROUGE)
					|| (sommet instanceof Parade && 
							!(sommet.equals(Cartes.FEU_VERT))) || (sommet instanceof Attaque );
		}
	}
	
	private boolean estDepotBorneAutorise(Borne b) {
		return peutAvancer()
				&& b.getKm() <= donnerLimitationVitesse()
				&& b.getKm() + donnerKmParcourus() <= 1000;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if (limite instanceof DebutLimite) {
			return pileLimites.isEmpty() || (donnerSommet(pileLimites) instanceof FinLimite);
		} else {
			return donnerSommet(pileLimites) instanceof DebutLimite;
		}
	}
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bataille instanceof Attaque) {
			return peutAvancer();
		}
		if (bataille instanceof Parade) {
			if (bataille.equals(Cartes.FEU_VERT)) {
				return estDepotFeuVertAutorise();
			} else {
				Bataille sommet = donnerSommet(pileBataille);
				return   (sommet instanceof Attaque) && sommet.getType().equals(bataille.getType());
			}
		}
		return false;
	}
	public void deposer(Carte carte) {
		if(carte instanceof Borne borne ) {
			pileBorne.add(borne) ;
		}
		else if(carte instanceof Bataille bataille) {
			pileBataille.add(bataille);
		}
		else if(carte instanceof Limite limite) {
			pileLimites.add(limite);
		}
		else if (carte instanceof Botte botte) {
			bottes.add(botte);
		}
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne borne ) {
			return estDepotBorneAutorise((borne));
		} else if (carte instanceof Limite limite ) {
			return estDepotLimiteAutorise(limite);
		} else if (carte instanceof Bataille ) {
			return estDepotBatailleAutorise((Bataille)carte);
		} else {
			return true;
		}
	}
	
}