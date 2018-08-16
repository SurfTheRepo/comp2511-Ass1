package assn1;

public class Room {

	private int name;
	private int size;
	private Booking[] bookings;
	
	public Room(int name, int size) {
		this.name = name;
		this.size = size;
		this.bookings = new Booking[365];
	}
	
	public boolean checkAvailbility(int size, int date_start, int date_end) {
		if(size == this.size) {
			for(int i = date_start; i <= date_end; i++) {
				if(this.bookings[i].getReserved()) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public void newBooking(String occupant, int date_start, int date_end) {
		for(int i = date_start; i <= date_end; i++) {
			this.bookings[i].setBooking(occupant);
		} 
	}
	public void cancelBooking(String name) {
		for(Booking var: this.bookings) {
			var.cancelBooking(name);
		}
	}
	
	
	
	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
