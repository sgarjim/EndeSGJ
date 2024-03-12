
public class Habitacion {
	private int numero;
	private String tipo;
	private boolean ocupada;
	
	public static final String[] TIPOS_HABITACIONES= {"SIMPLE", "DOBLE", "TRIPLE"};
	
	//Falta completar el control de errores en este método
	//Tirando la excepción cuando sea necesario
	public Habitacion(int numero, String tipo) throws HotelException {
		boolean valido=false;
		for (int i = 0; i < TIPOS_HABITACIONES.length && !valido; i++) {
			if(tipo.equalsIgnoreCase(TIPOS_HABITACIONES[i])) {
				valido=true;
			}
		}
		if (!valido) {
			throw new HotelException("Tipo de habitación no válido");
		}
		if (numero<=0) {
			throw new HotelException("Número erróneo");
		}
		this.numero = numero;
		this.tipo = tipo;
		this.ocupada=false;
	}

	public int getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}


	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	@Override
	public String toString() {
		String cadena;
		cadena="Nº" + numero + ", tipo: " + tipo ;
		if (ocupada) {
			cadena=cadena + " ocupada";
		}
		else {
			cadena=cadena + " libre";
		}
		return cadena;
	}


	
	
	
}