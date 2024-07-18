package n3exercici1;

import java.util.ArrayList;

import n2exercici1.Entrada;

public class Cine {
	
	private int numFiles;
	private int numSeients;
	private GestioButaques gestio;
	
	public Cine() {
		this.gestio = new GestioButaques();
		this.demanarDadesInicials();
		System.out.println("Cinema creat.");
	}
	
	public void iniciar() {
		boolean sortir = false;
	
		do {
			switch(this.menu()) {
			case 1:				
				for (Butaca butaca : mostrarButaques()) {
					System.out.println(butaca + "\n");
				}
			
				break;
			case 2:
				try {
					for (Butaca butaca : mostrarButaquesPersona(introduirPersona())) {
						System.out.println(butaca);
					}
				} catch (ExcepcioNomPersonaIncorrecte e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				reservarButaca();
				break;
			case 4:
				anularReserva();
				break;
			case 5:
				anularReservaPersona();
				break;
			case 0:
				System.out.println("Fins a la propera!");
				sortir = true;
				break;
			default:
				System.out.println("Tria una opció correcta!");
			}
		}while(!sortir);
		
	}
	
	
	private int menu() {
		final String MENU = "\nIndica una opció:"
				+ "\n1.- Mostrar totes les butaques reservades."
				+ "\n2.- Mostrar les butaques reservades per una persona."
				+ "\n3.- Reservar una butaca."
				+ "\n4.- Anul·lar la reserva d’una butaca."
				+ "\n5.- Anul·lar totes les reserves d’una persona."
				+ "\n0.- Sortir.";
		return Entrada.llegirInt(MENU);
	}
	
	private ArrayList<Butaca> mostrarButaques() {
		return this.gestio.getButaques();
	}
	
	private ArrayList<Butaca> mostrarButaquesPersona(String persona) {
		ArrayList<Butaca> butaques = new ArrayList<Butaca>();
		for (Butaca butaca : mostrarButaques()) {
			if(butaca.getPersona().equalsIgnoreCase(persona)) {
				butaques.add(butaca);
			}
		}
		return butaques;
	}
	
	private void reservarButaca() {
		int fila = 0, seient = 0;
		String persona = "";
		
		try {
			fila = introduirFila();
			seient = introduirSeient();
			persona = introduirPersona();
			gestio.afegirButaca(new Butaca(fila, seient, persona));
			System.out.println("Butaca reservada");
		} catch (ExcepcioNomPersonaIncorrecte | ExcepcioSeientIncorrecte | ExcepcioFilaIncorrecta | ExcepcioButacaOcupada e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void anularReserva() {
		try {
			gestio.eliminarButaca(introduirFila(), introduirSeient());
			System.out.println("Reserva eliminada");
		} catch (ExcepcioButacaLliure | ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void anularReservaPersona() {
		try {
			int i = 0;
			for (Butaca butaca : mostrarButaquesPersona(introduirPersona())){
				gestio.eliminarButaca(butaca.getFila(), butaca.getSeient());
				i++;
			}
			System.out.println(i > 0 ? String.format("Eliminada una reserva de %d butaques.", i) : "No hi ha cap reserva a aquest nom.");
		} catch (ExcepcioNomPersonaIncorrecte | ExcepcioButacaLliure e) {
			System.out.println(e.getMessage());
		}
	}
	
	private String introduirPersona() throws ExcepcioNomPersonaIncorrecte{
		String nom = Entrada.llegirString("Introdueix el nom de la persona");
		for (int i = 0 ; i < nom.length() ; i++) {
			if (nom.charAt(i) >= 48 && nom.charAt(i) <= 57) {
				throw new ExcepcioNomPersonaIncorrecte("Error, nom incorrecte, no pot contenir números.");
			}
		}
		return nom;
	}
	
	private void demanarDadesInicials(){
		this.numFiles = Entrada.llegirInt("Indica el nombre de files del cinema: ");
		this.numSeients = Entrada.llegirInt("Indica el nombre de seients per fila: ");
	}
	
	private int introduirFila() throws ExcepcioFilaIncorrecta{
		int fila = Entrada.llegirInt("Indica el número de fila");
		if (!(fila > 0 && fila <= this.numFiles)) {
			throw new ExcepcioFilaIncorrecta("Error, el número de fila és incorrecte");
		}
		return fila;
	}
	
	private int introduirSeient() throws ExcepcioSeientIncorrecte{
		int fila = Entrada.llegirInt("Indica el número de seient");
		if (!(fila > 0 && fila <= this.numSeients)) {
			throw new ExcepcioSeientIncorrecte("Error, el número de seient és incorrecte");
		}
		return fila;
	}
	
	
	

}
