package assn1;

public class Booking {

	private Hotel hotel;
	private Room room;
	private String occupant;
	private int date;
	
	public Booking(String occupant, int date) {
		this.occupant = occupant;
		this.date = date;
	}

	
	
	
	
	
	
	public String getOccupant() {
		return occupant;
	}
	public void setOccupant(String occupant) {
		this.occupant = occupant;
	}

	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	
	
	
}
