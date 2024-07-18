package n1exercici1;

import java.util.ArrayList;

public class Venda {
	
	private ArrayList<Producte> productes;
	int preuTotal;
	
	public Venda() {
		productes = new ArrayList<Producte>();
		preuTotal = 0;
	}
	
	public Producte getProducte(int index) {
		return this.productes.get(index);
	}
	
	public int getPreuTotal() {
		return this.preuTotal;
	}
	
	public void setProducte(Producte producte) {
		this.productes.add(producte);
	}
	
	public void eliminaProducte(int index) {
		this.productes.remove(index - 1);
	}
	
	public void calcularTotal() throws VendaBuidaException{
		if (productes.isEmpty()) {
			throw new VendaBuidaException("Per fer una venda primer has d'afegir productes");
		}
		this.preuTotal = 0;
		for(Producte producte : productes) {
			this.preuTotal += producte.getPreu();
		}
		
	}
	
	@Override
	public String toString() {
		String resposta = productes.isEmpty() ? "La cistella està buida" : "Els productes de la cistella són:";
		int i = 1;
		for (Producte producte : productes) {
			resposta += "\n" + i + ".- " + producte;
			i++;
		}
		return resposta;
	}
		

}
