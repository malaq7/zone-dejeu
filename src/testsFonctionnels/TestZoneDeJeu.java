package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;
import jeu.MainJoueur;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {
	public static void main(String[] args) {
		// TP3 PARTIE 2
		
		// TP3 PARTIE 3
		boolean depotOK = false;
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		System.out.println("Deposer carte Feu rouge");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte attaque - accident");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte attaque - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ESSENCE));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ESSENCE));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte parade - roue de secours");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.CREVAISON));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.CREVAISON));
		}
		System.out.println("dépot ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte parade - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.ESSENCE));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.ESSENCE));
		}
		System.out.println("dépot ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new DebutLimite());
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte borne - 25");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(25));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(25));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte fin limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new FinLimite());
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new FinLimite());
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

// RESULTAT ATTENDU POUR LA PARTIE 3 (ne pas d�commenter)
// 			Deposer carte Feu rouge
//			d�p�t ok ? false
//			peut avancer ? false
//			Deposer carte attaque - accident
//			d�p�t ok ? false
//			peut avancer ? false
//			Deposer carte Feu vert
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte attaque - essence
//			d�p�t ok ? true
//			peut avancer ? false
//			Deposer carte parade - roue de secours
//			d�p�t ok ? false
//			peut avancer ? false
//			Deposer carte parade - essence
//			d�p�t ok ? true
//			peut avancer ? false
//			Deposer carte Feu vert
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte borne - 100
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte limite - 50
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte borne - 100
//			d�p�t ok ? false
//			peut avancer ? true
//			Deposer carte borne - 25
//			peut avancer ? true
//			Deposer carte fin limite - 50
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte borne - 100
//			d�p�t ok ? true
//			peut avancer ? true

		
		
		//RESULTAT ATTENDU POUR LE TP4 Partie 1
//		Deposer carte Feu rouge
//		d�p�t ok ? false
//		peut avancer ? false
//		Deposer carte Vehicule prioritaire
//		d�p�t ok ? true
//		peut avancer ? true
//		Deposer carte attaque - accident
//		d�p�t ok ? true
//		peut avancer ? false
//		Deposer botte - roue de secours
//		d�p�t ok ? true
//		peut avancer ? false
//		Deposer carte as du volant
//		d�p�t ok ? true
//		peut avancer ? true
//		Deposer carte Feu vert
//		d�p�t ok ? false
//		peut avancer ? true
//		Deposer carte accident
//		d�p�t ok ? false
//		peut avancer ? true
//		Deposer carte limite - 50
//		d�p�t ok ? false
//		peut avancer ? true
	}
}
