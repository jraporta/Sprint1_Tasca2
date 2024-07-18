package n3exercici1;

public class Butaca {

	private int fila;
	private int seient;
	private String persona;
	
	public Butaca(int fila, int seient, String persona) {
		this.fila = fila;
		this.seient = seient;
		this.persona = persona;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public int getSeient() {
		return this.seient;
	}
	
	public String getPersona() {
		return this.persona;
	}
	
	@Override
	public boolean equals(Object o) {
		Butaca butaca = (Butaca) o;
		return this.fila == butaca.fila && this.seient == butaca.seient;
	}
	
	@Override
	public String toString() {
		return String.format("Fila: %d, Seient: %d, Persona: %s", this.fila, this.seient, this.persona);
	}
}
