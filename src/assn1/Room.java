package assn1;

public class Room {

	private Hotel hotel;
	private String name;
	private int size;
	private Booking[] bookings;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
