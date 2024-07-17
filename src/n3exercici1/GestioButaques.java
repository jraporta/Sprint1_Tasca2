package n3exercici1;

import java.util.ArrayList;

public class GestioButaques {
	
	private ArrayList<Butaca> butaques;
	
	public GestioButaques() {
		this.butaques = new ArrayList<Butaca>();
	}
	
	public ArrayList<Butaca> getButaques(){
		return this.butaques;
	}
	
	public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {
		if (cercarButaca(butaca) != -1) {
			throw new ExcepcioButacaOcupada ("La butaca ja està ocupada");
		}
		butaques.add(butaca);
	}
	
	public int cercarButaca(Butaca butaca) {
		boolean trobada = false;
		int i = 0;
		while ( !trobada && i < butaques.size()) {
			trobada = butaca.equals(butaques.get(i));
			i++;
		}
		return trobada ? i - 1 : -1;
	}
	
	public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure{
		int posicio = cercarButaca(new Butaca(fila, seient, ""));
		if ( posicio == -1 ) {
			throw new ExcepcioButacaLliure("La butaca està lliure");
		}
		butaques.remove(posicio);		
	}

}
