package utils;
import java.util.List;
import java.util.ArrayList;
import cartes.*;
import java.util.Random;
import java.util.Iterator;
import java.util.Collections;
import java.util.ListIterator;


public class GestionCartes {
	private static List<Carte> liste=new ArrayList<>();
	
	public static Carte extraire1(Carte cartes) {
		int min=0;
		int nbCartes = liste.size();
		Random random = new Random();
		int value = random.nextInt(nbCartes + min) + min;
		Carte carte = liste.get(value);
	
		for(int i=value;i<nbCartes-1;i++) {
			liste.set(i,liste.get(i));
		}
		return carte;
	}
	
	public static Carte extraire(List<Carte> cartes) {
		int nbCartes = liste.size();
		Random random = new Random();
		int value = random.nextInt(nbCartes ) ;
		Iterator<Carte> It = liste.iterator();
		Carte courant =It.next();
		int i;
		for(i =0 ; i<value;i ++){
			courant =It.next();				
		}
		liste.remove(i);
		return courant ;
	}
	
	
	public static List<Carte> melanger(List<Carte> cartes) {
		for(Iterator<Carte> it2 = liste.iterator();it2.hasNext();) {
				Carte courant2 = extraire(cartes);
					liste.add(courant2);
				}
		return liste;
	}
	
	public static boolean verifierMelange(List<Carte> list1, List<Carte> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
        	Carte a = list1.get(i);
            boolean found = false;
            for (int j = 0; j < list1.size() && !found; j++) {
                Carte b = list2.get(j);
                if (a.equals(b) && Collections.frequency(list1, a) != Collections.frequency(list2, b)) {
                    return false;
                } else if (a.equals(b)) {
                    found = true;
                }
            }
        }
        
        return true;
    }
	 public static List<Carte> rassembler(List<Carte> liste) {
	        int longueur = liste.size();
	        List<Carte> listTriee = new ArrayList<>(longueur);
	        while(longueur > 0) {
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
   
	 public static boolean verifierRassemblement(List<Carte> liste) {
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
    
    
	}
