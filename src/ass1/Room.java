package ass1;

/**
 * Class room which is an object that belongs to a hotel, contains bookings
 * a name and a specific size.
 * 
 * @author ottof
 *
 */
public class Room {

	private int name;
	private String size;
	private Booking[] bookings;
	
	/**
	 * Constructor that inits the array of bookings and then name and size of room
	 * @param name Name of room
	 * @param size Size of room
	 */
	public Room(int name, String size) {
		this.name = name;
		this.size = size;
		this.bookings = new Booking[365];
		for(int i =0; i<365;i++) {
			this.bookings[i] = new Booking();
		}
	}
	
	/**
	 * void method that prints the bookings in the room 
	 * for the year in Month Date Duration format on one line
	 */
	public void printBookings() {
		String occupant;
		int duration=0;
		for(int i = 0; i< 365; i++) {
			if(this.bookings[i].getReserved()) {
				System.out.print(MonthCalculator.intToDate(i) + " ");
				occupant = this.bookings[i].getOccupant();
				while(occupant.matches(this.bookings[i].getOccupant())) {
					duration++;
					i++;
				}
				System.out.print((duration-1)+ " ");
			}
			
		}
	}
	public boolean sanityCheckAvailility(int date, int end_date) {
		for(int i = date; i <= end_date; i++) {
			if(this.bookings[i].getReserved()) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Method that determines if room is available for specific size and dates
	 * @param size Size of room
	 * @param date_start start of booking
	 * @param date_end end date of booking
	 * @return Boolean representing if the room is availble
	 */
	public boolean checkAvailbility(String size, int date_start, int date_end) {
		if(size.matches(this.size)) {
			for(int i = date_start; i <= date_end; i++) {
				if(this.bookings[i].getReserved()) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Very similar to checkAvailbilty method, except is used when trying to 
	 * change a booking and so ignores bookings under the specified name
	 * @param name name to ignore
	 * @param size size of room
	 * @param date_start date booking starts
	 * @param date_end date booking ends
	 * @return boolean for if room is available
	 */
	public boolean checkAvailbilityIgnoreSpecific(String name, String size, int date_start, int date_end) {
		if(size.matches(this.size)) {
			for(int i = date_start; i <= date_end; i++) {
				if(this.bookings[i].getReserved() && !name.matches(this.bookings[i].getOccupant())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	
	/**
	 * Creates new booking in the room under a specified name and dates
	 * @param occupant Occupant
	 * @param date_start start of booking
	 * @param date_end end of booking
	 */
	public void newBooking(String occupant, int date_start, int date_end) {
		for(int i = date_start; i <= date_end; i++) {
			this.bookings[i].setBooking(occupant);
		} 
	}
	
	/**
	 * Cancels booking under specified name
	 * @param name occupant to cancel
	 */
	public void cancelBooking(String name) {
		for(Booking var: this.bookings) {
			var.cancelBooking(name);
		}
	}
	/**
	 * getter for String Name
	 * @return name as String
	 */
	public int getName() {
		return name;
	}
	
		
	/**
	 * getter for size of room
	 * @return size of room as string
	 */
	public String getSize() {
		return size;
	}
}
