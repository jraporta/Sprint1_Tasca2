package n1exercici1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String MENU = "Tria una opció:"
				+ "\n1. Afegir producte."
				+ "\n2. Calcular el preu total."
				+ "\n3. Mostrar productes."
				+ "\n4. Elimina producte";
		Venda venda = new Venda();
		Scanner entrada = new Scanner(System.in);
		int opcio = 0;
		String nomProducte = "";
		int preuProducte = 0;
		int indexEliminar = 0;
		
		do {
			System.out.println("\n" + MENU);
			opcio = entrada.nextInt();
			switch(opcio) {
			case 1:
				System.out.print("Indica el nom del producte: ");
				nomProducte = entrada.next();
				System.out.print("Indica el preu del producte: ");
				preuProducte = entrada.nextInt();
				venda.setProducte(new Producte(nomProducte, preuProducte));
				break;
			case 2:
				try {
					venda.calcularTotal();
					System.out.println(venda.getPreuTotal());
				}catch(VendaBuidaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println(venda);
				break;
			case 4:
				System.out.print("Indica el número del producte a eliminar: ");
				indexEliminar = entrada.nextInt();
				try {
					venda.eliminaProducte(indexEliminar);
					System.out.println("El producte s'ha eliminat");
				}catch(IndexOutOfBoundsException e) {
					System.out.println("Error en l'informació introduïda, producte no existent!");
				}
				break;
			default:
				System.out.println("Tria una opció vàlida");
			}
			
		}while (opcio !=0);
		entrada.close();
	}

}
