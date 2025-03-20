package cartes;

public class Borne extends Carte {

	private int km;

	public Borne(int km) {
		this.km = km;
	}
	public int getKm() {
        return km;
    }

    @Override
    public String toString() {
        return km+"KM";
    }
    @Override
	public boolean equals(Object obj) {
	 if(super.equals(obj)){
		 if(obj instanceof Borne ) {
			Borne borne = (Borne) obj; 
			return km == borne.getKm();
		 }
		 return false;
	 }
	 return false;
	}
   

}
