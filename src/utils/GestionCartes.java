package utils;

import java.util.List;
import java.util.ArrayList;
import cartes.*;
import java.util.Random;
import java.util.Collections;
import java.util.ListIterator;

public class GestionCartes {
	private static List<Carte> liste = new ArrayList<>();
	private static Random seed = new Random();


	public static Carte extraire1(Carte cartes) {
		int nbCartes = liste.size();
		int value = seed.nextInt(nbCartes);
		//TODO simplifier
		return liste.remove(value);	}

	public static Carte extraire(List<Carte> cartes) {
		if (cartes.isEmpty()) {
			return null;
		}
		//TODO ListIterator
		ListIterator<Carte> iterator = cartes.listIterator();
		int i = seed.nextInt(cartes.size());
		Carte courant = null;
		for (; iterator.hasNext()&&i>=0; i--) {
			courant = iterator.next();
		}
		iterator.remove();
		return courant;
	}

	public static List<Carte> melanger(List<Carte> listePasMelangee) {
		int taille = listePasMelangee.size();
		List<Carte> listeMelangee = new ArrayList<>();
		for (int i = 0; i < taille; i++) {
			listeMelangee.add(extraire(listePasMelangee));
		}
		listePasMelangee.addAll(listeMelangee);
		return listePasMelangee;
	}

	public static <E> boolean verifierMelange(List<E> list1, List<E> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        
        for (int i = 0; i < list1.size(); i++) {
            boolean found = false;
            for (int j = 0; j < list1.size() && !found; j++) {
                E e1 = list1.get(i);
                E e2 = list2.get(i);
                if (e1.equals(e2) && Collections.frequency(list1, e1) != Collections.frequency(list2, e2)) {
                    return false;
                } else if (e1.equals(e2)) {
                    found = true;
                }
            }
        }
        
        return true;
    }

	public static List<Carte> rassembler1(List<Carte> liste) {
		//TODO utiliser contains
		int longueur = liste.size();
		List<Carte> listTriee = new ArrayList<>(longueur);
		while (longueur > 0) {
			Carte element = liste.get(0);
			int frequence = Collections.frequency(liste, element);
			for (int j = 0; j < frequence; j++) {
				listTriee.add(element);
				liste.remove(element);
				longueur--;
			}
		}
		return listTriee;
	}
	public static List<Carte> rassembler(List<Carte> liste) {
	    List<Carte> listTriee = new ArrayList<>();
	    List<Carte> copieListe = new ArrayList<>(liste);

	    for (Carte element : liste) { 	       
	        if (!listTriee.contains(element)) { 
	            int frequence = Collections.frequency(copieListe, element);
	            for (int j = 0; j < frequence; j++) {
	                listTriee.add(element);
	            }
	        }
	    }
	    return listTriee;
	}
	

	public static boolean verifierRassemblement1(List<Carte> liste) {
		Carte precedent = null;
		int i = 0;
		for (ListIterator<Carte> iter1 = liste.listIterator(); iter1.hasNext();) {
			Carte carte1 = iter1.next();
			if (precedent != null && !carte1.equals(precedent)) {
				int j = 0;
				for (ListIterator<Carte> iter2 = liste.listIterator(); iter2.hasNext();) {
					Carte carte2 = iter2.next();
					if (j > i && carte2.equals(precedent)) {
						return false;
					}
					j++;
				}
			}
			precedent = carte1;
			i++;
		}
		return true;
	}
	
	public static boolean trouverElementFinListe(List<Carte> listeRassemble, Carte element, int i) {
		int j = 0;
		for (ListIterator<Carte> iter2 = listeRassemble.listIterator(); iter2.hasNext();) {
			Carte elem2 = iter2.next();
			if (j > i && elem2.equals(element)) {
				return false;
			}
			j++;
		}
		return true;
	}
	
	public static boolean verifierRassemblement(List<Carte> listeRassemble) {
		Carte prev = null;
		int i = 0;
		for (ListIterator<Carte> iter1 = listeRassemble.listIterator(); iter1.hasNext();) {
			Carte elem1 = iter1.next();
			if (prev != null && !elem1.equals(prev)) {
				if (!trouverElementFinListe(listeRassemble, prev, i)) return false;
			}
			prev = elem1;
			i++;
		}
		return true;
	}

}
