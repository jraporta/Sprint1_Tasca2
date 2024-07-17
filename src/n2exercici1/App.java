package n2exercici1;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String MENU = "Indica una opció:"
				+ "\n1. Llegir un byte"
				+ "\n2. Llegir un enter"
				+ "\n3. Llegir un float"
				+ "\n4. Llegir un double"
				+ "\n5. Llegir un caràcter"
				+ "\n6. Llegir una cadena de text"
				+ "\n7. Llegir un SI/NO"
				+ "\n0. Sortir";
		byte opcio = 0;
		
		
		do {
			System.out.println("\n" + MENU);
			opcio = Entrada.llegirByte("");
			switch(opcio) {
			case 1:
				System.out.println("Ben fet, s'ha llegit: " + Entrada.llegirByte("Escriu un 'byte':"));
				break;
			case 2:
				System.out.println("Ben fet, s'ha llegit: " + Entrada.llegirInt("Escriu un 'int':"));
				break;
			case 3:
				System.out.println("Ben fet, s'ha llegit: " + Entrada.llegirFloat("Escriu un 'float':"));
				break;
			case 4:
				System.out.println("Ben fet, s'ha llegit: " + Entrada.llegirDouble("Escriu un 'double':"));
				break;
			case 5:
				System.out.println("Ben fet, s'ha llegit: " + Entrada.llegirChar("Escriu un 'char':"));
				break;
			case 6:
				System.out.println("Ben fet, s'ha llegit: " + Entrada.llegirString("Escriu un 'String':"));
				break;
			case 7:
				System.out.println("Ben fet, s'ha llegit: " + Entrada.llegirSiNo("Escriu un 's' o 'n':"));
				break;
			}
		}while (opcio != 0);

	}

}
