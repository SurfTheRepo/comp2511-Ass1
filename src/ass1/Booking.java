package ass1;

/**
 * @author ottof
 * Booking class which each room has 365 of
 * to represent a possible booking for each day of the year
 */
public class Booking {

	private String occupant;
	private boolean reserved;
	
	/**
	 * constructor, sets values to that of non-reserved booking
	 */
	public Booking() {
		this.reserved = false;
		this.occupant = "";
	}

	/**
	 * Sets a booking to a specific occupant
	 * @param occupant Occupant
	 */
	public void setBooking(String occupant) {
		this.occupant = occupant;
		this.reserved = true;
	}
	
	/**
	 * Cancels occupants booking 
	 * @param occupant Occupant
	 */
	public void cancelBooking(String occupant) {
		if(this.occupant.matches(occupant)) {
			this.occupant = "";
			this.reserved = false;
		}
	}
	
	/**
	 * returns status of booking as a boolean
	 * @return status
	 */
	public boolean getReserved() {
		return reserved;
	}
	
	/**
	 * get method for occupant as a string
	 * @return occupant
	 */
	public String getOccupant() {
		return occupant;
	}
	
}
