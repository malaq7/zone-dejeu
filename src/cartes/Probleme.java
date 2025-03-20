package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	protected Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	@Override
	public String toString() {
		return ""+ getType();
	}
	
	@Override
	//TODO  simplifier
	public boolean equals(Object obj) {
	 if(super.equals(obj)){
		 if(obj instanceof Probleme) {
			 Probleme probleme = (Probleme) obj;
			 return type.equals(probleme.getType());
		 }
		 return false;
	 }
	 return false;
	}
}
