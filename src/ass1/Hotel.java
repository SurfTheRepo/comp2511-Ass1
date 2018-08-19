package ass1;

import java.util.ArrayList;


/**
 * Class for HotelBookingSystem
 * used to create and interact with hotel classes
 * @author ottof
 *
 */
public class Hotel {
	
	private ArrayList<Room> rooms;
	private String name;
	private ArrayList<String> people_booked;
	
	/**
	 * Constructor for Hotel, takes in name and create a hotel
	 * has ArrayList of rooms and arrayList of the current occupants in hotel
	 * @param name name of hotel
	 */
	public Hotel(String name) {
		this.name = name;
		this.rooms = new ArrayList<Room>(); 
		this.people_booked = new ArrayList<String>();
	}
	
	/**
	 * creates a new room with name and size and adds to the hotel
	 * @param name name of room
	 * @param size size of room
	 */
	public void newRoom(int name, int size) {
		if(size == 1) {
			this.rooms.add(new Room(name, "single"));
		} else if (size ==2 ) {
			this.rooms.add(new Room(name, "double"));
		} else if (size == 3) {
			this.rooms.add(new Room(name, "triple"));
		}
	}
	
	/**
	 * Creates new booking at the hotel
	 * @param name name of occupant
	 * @param size size of room needed
	 * @param str_amount amount of rooms needed
	 * @param date start date of booking
	 * @param duration duration of booking
	 * @return ArrayList of rooms booked
	 */
	public ArrayList<Integer> newBooking(String name, String size, String str_amount, int date, int duration) {
		ArrayList<Integer> roomsBooked = new ArrayList<Integer>();
		int count = 0;
		int amount = Integer.valueOf(str_amount);
		for(Room room: this.rooms) {
			if(count == amount) {
				this.people_booked.add(name);
				return roomsBooked;
			}
			if(room.getSize().matches(size)) {
				room.newBooking(name, date, date+duration-1);
				roomsBooked.add(room.getName());
				count++;
				
			}
		}
		return roomsBooked;
	}
	
	/**
	 * Checks if hotel can accomadate a booking
	 * @param size size of room
	 * @param str_amount amount of rooms needed
	 * @param date start of booking
	 * @param duration duration of booking
	 * @return boolean of if can accomadate
	 */
	public boolean checkAvailbility(String size, String str_amount, int date, int duration) {
		int amount = Integer.valueOf(str_amount);
		int count = 0;
		for(Room room: this.rooms) {
			if(room.checkAvailbility(size, date, date+duration-1)) {
				count++;
			}		
		}
		if(count >= amount) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * similar to checkAvailbility method but ignores a specific name
	 * as is used in change booking method
	 * @param name name to ignore
	 * @param size size of room needed
	 * @param str_amount amount of rooms needed
	 * @param date start of date needed
	 * @param duration duration of booking
	 * @return boolean of if can accomadate
	 */
	public boolean checkAvailbilityIgnoreSpecific(String name, String size, String str_amount, int date, int duration) {
		int amount = Integer.valueOf(str_amount);
		int count = 0;
		for(Room room: this.rooms) {
			if(room.checkAvailbilityIgnoreSpecific(name, size, date, date+duration-1)) {
				count++;
			}		
		}
		if(count >= amount) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Prints rooms that are part of the hotel and the dates they are booked for
	 */
	public void printRooms() {
		for(Room room: this.rooms) {
			System.out.print(this.name);
			System.out.print(" "+ room.getName()+ " ");
			room.printBookings();
			System.out.print("\n");
		}	
	}
	
	/**
	 * Checks if a occupant is stayin at the hotel
	 * @param name person testing
	 * @return boolean of if person is staying
	 */
	public boolean isPersonStaying(String name) {
		for(String people: this.people_booked) {
			if(name.matches(people)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Cancels all bookings under a specific name at the hotel
	 * @param name name to cancel
	 */
	public void cancelBooking(String name) {
		this.people_booked.remove(name);
		for(Room room:this.rooms) {
			room.cancelBooking(name);
		}
	}
	
	/**
	 * getter for name of hotel
	 * @return name of hotel
	 */
	public String getName() {
		return name;
	}
}
