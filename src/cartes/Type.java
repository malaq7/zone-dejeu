package cartes;

public enum Type {

	FEU("FeuRouge", "FeuVert", "VehiculePrioriataire "), ESSENCE("Panne d'essence", "Bidon d'essence", "Citerne"),
	CREVAISON("Crevaison", "Roue de secours", "Increvable"), ACCIDENT("Accident", "Réparation", "As du volant");

	private String attaque;
	private String parade;
	private String botte;
	
	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}

}
