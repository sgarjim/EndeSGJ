public class Hotel {
	public static final String[] TIPOS_HABITACIONES = { "SIMPLE", "DOBLE", "TRIPLE" };
	private Habitacion[] habitaciones;

	public Hotel(int simples, int dobles, int triples) throws HotelException {
		// Primero controlar excepciones. si datos incorrectos tirar excepción
		if (simples < 0 || dobles < 0 || triples < 0) {
			throw new HotelException("Datos incorrectos");
		}
		int total = simples + dobles + triples;
		habitaciones = new Habitacion[total];
		int recuentoHabitaciones;
		for (recuentoHabitaciones = 0; recuentoHabitaciones < simples; recuentoHabitaciones++) {
			habitaciones[recuentoHabitaciones] = new Habitacion(recuentoHabitaciones + 1, "SIMPLE");
		}
		for (recuentoHabitaciones = recuentoHabitaciones; recuentoHabitaciones < (simples
				+ dobles); recuentoHabitaciones++) {
			habitaciones[recuentoHabitaciones] = new Habitacion(recuentoHabitaciones + 1, "DOBLE");
		}
		for (recuentoHabitaciones = recuentoHabitaciones; recuentoHabitaciones < total; recuentoHabitaciones++) {
			habitaciones[recuentoHabitaciones] = new Habitacion(recuentoHabitaciones + 1, "TRIPLE");
		}
	}

	public int checkIn(String tipoHabitacion) throws HotelException {
		boolean habitacionEncontrada=false,valido = false;
		int numeroHabitacion=0;
		tipoHabitacion = tipoHabitacion.toUpperCase();
		for (int i = 0; i < TIPOS_HABITACIONES.length && !valido; i++) {
			if (tipoHabitacion.equals(TIPOS_HABITACIONES[i])) {
				valido = true;
			}
		}
		if (!valido) {
			throw new HotelException("Tipo de habitación no válido");
		}
		for (int i = 0; i < habitaciones.length && !habitacionEncontrada; i++) {
			if (habitaciones[i].getTipo().equals(tipoHabitacion) && !habitaciones[i].isOcupada()) {
				numeroHabitacion=habitaciones[i].getNumero();
				habitaciones[i].setOcupada(true);
				habitacionEncontrada=true;
			}
		}
		if (!habitacionEncontrada) {
			throw new HotelException("No quedan habitaciones libres de ese tipo");
		}
		return numeroHabitacion;
	}
	public void checkOut(int numeroHabitacion) throws HotelException {
		if (numeroHabitacion>habitaciones.length || numeroHabitacion<=0) {
			throw new HotelException ("Número de habitación incorrecto");
		}
		habitaciones[numeroHabitacion-1].setOcupada(false);
	}
	
}