package ass1;

public class Hotel {
	private static int BIG_ENOUGH_NUMBER = 10;
	
	private Room[] rooms;
	private String name;
	private int number_of_rooms;
	
	public Hotel(String name) {
		this.name = name;
		this.rooms = new Room[BIG_ENOUGH_NUMBER]; 
		this.number_of_rooms = 0;
	}
	
	public void newRoom(int name, int size) {
		this.rooms[number_of_rooms] = new Room(name, size);
		this.number_of_rooms++;
	}
	
	//new booking
	public void newBooking(int name, int size, int date_start, int duration) {
		
	}
	//take a list of size and dates and see if can accommodate;
	public boolean checkAvailbility(int[] sizes, int[] dates, int[] duration) {
		
		
		return true;
	}
	
	
	public void printRooms() {
		for(int i = 0; i< number_of_rooms; i++) {
			System.out.println(this.name + " " + this.rooms[i].toString());
		}
		
	}
	
	
	public String getName() {
		return name;
	}

}
