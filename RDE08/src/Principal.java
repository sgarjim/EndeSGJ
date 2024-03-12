
public class Principal {

	public static void main(String[] args) {
		try {
			int numHabitacion;
			Hotel hotel=new Hotel(2,4,5);
			numHabitacion=hotel.checkIn("SIMPLE");
			System.out.println(numHabitacion);
			hotel.checkOut(numHabitacion);
			System.out.println(hotel.checkIn("SIMPLE"));
			System.out.println(hotel.checkIn("DOBLE"));
			System.out.println(hotel.checkIn("TRIPLE"));
			System.out.println(hotel.checkIn("SIMPLE"));
			System.out.println(hotel.checkIn("SIMPLE"));
		} catch (HotelException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

}
