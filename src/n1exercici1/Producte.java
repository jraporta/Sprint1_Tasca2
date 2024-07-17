package n1exercici1;

public class Producte {
	
	private String nom;
	private int preu;
	
	public Producte(String nom, int preu) {
		this.nom = nom;
		this.preu = preu;
	}
	
	public int getPreu() {
		return this.preu;
	}
	
	public String toString() {
		return String.format("Producte: %s - Preu: %s€", this.nom, this.preu);
	}

}
