package assn1;

public class Booking {

	private String occupant;
	private boolean reserved;
	
	public Booking(String occupant, boolean reserved) {
		this.occupant = occupant;
		this.reserved = reserved;
	}
	
	public void setBooking(String occupant) {
		this.occupant = occupant;
		this.reserved = true;
	}
	public void cancelBooking(String occupant) {
		if(this.occupant.matches(occupant)) {
			this.occupant = "";
			this.reserved = false;
		}
	}
	
	public boolean getReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public String getOccupant() {
		return occupant;
	}
	public void setOccupant(String occupant) {
		this.occupant = occupant;
	}
}
