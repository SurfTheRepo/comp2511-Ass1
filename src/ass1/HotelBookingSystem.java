package ass1;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import ass1.MonthCalculator;
/**
 * Hotel booking system, contains the main to run the program
 * takes in a file from command line and scans through for commands
 * to do and builds list of hotels and their details
 * @author ottof
 *
 */

public class HotelBookingSystem {

	//private String current_command;
	private ArrayList<Hotel> hotels;
	
	/**
	 * Constructor for the booking system 
	 * creates arraylist for the hotels
	 */
	public HotelBookingSystem() {
		this.hotels = new ArrayList<Hotel>();
	}
	
	/**
	 * turns the taken in command and sends it to the correct
	 * function
	 * @param command command to be interpretted
	 */
	public void commandInterpreter(String command) {
    	String command_arr[] = command.split(" ",2);
    	
    	//commands:
		if (command_arr[0].matches("Hotel")) {
			//System.out.println("Hotel");
			this.hotelCommand(command_arr[1]);
			//Hotel <hotelname> <roomnumber> <capacity>
		} else if (command_arr[0].matches("Print")) {
			//System.out.println("Print");
			this.printCommand(command_arr[1]);
			//Print <hotelname>
		} else if (command_arr[0].matches("Booking")) {
			//System.out.println("Booking");
			this.bookingCommand(command_arr[1]);
			//Booking <name> <month> <date> <numdays> <type1> <number1> <type2> <number2> . . .
		} else if (command_arr[0].matches("Change")) {
			//System.out.println("Change");
			this.changeCommand(command_arr[1]);
			//Change <name> <month> <date> <numdays> <type1> <number1> <type2> <number2> . . .
		} else if (command_arr[0].matches("Cancel")) {
			//System.out.println("Cancel");
			System.out.println("Cancel " + command_arr[1]);
			this.cancelCommand(command_arr[1]);
			//Cancel <name>
		} else {
			//System.out.println("CUCKED: "+ command);
		}
		return;
    }
	
	/**
	 * Method when Hotel command is called
	 * creates a hotel if hotel of the name doesnt already exist
	 * and creates a room to go in the hotel
	 * @param command 
	 */
	public void hotelCommand(String command) {  //done
		String command_arr[] = command.split(" ",2);
		String roomDetails[] = command_arr[1].split(" ", 2);
		if(this.hotels.isEmpty()) {
			Hotel newHotel = new Hotel(command_arr[0]);
			newHotel.newRoom(Integer.valueOf(roomDetails[0]), Integer.valueOf(roomDetails[1]));
			this.hotels.add(newHotel);
		} else {
			for(Hotel hotel: this.hotels) {
				if(command_arr[0].matches(hotel.getName())) {
					hotel.newRoom(Integer.valueOf(roomDetails[0]), Integer.valueOf(roomDetails[1]));
					return;
				}
			}
			Hotel newHotel = new Hotel(command_arr[0]);
			newHotel.newRoom(Integer.valueOf(roomDetails[0]), Integer.valueOf(roomDetails[1]));
			this.hotels.add(newHotel);
		}
	}
	
	/**
	 * Method when booking a room, takes in command and splits
	 * it into name, dates, duration, room sizes and amount of rooms
	 * if room is able to book, will output the booking and rooms booked
	 * other wise rejects booking message occurs
	 * @param command
	 */
	public void bookingCommand(String command) { //done!
		//Booking <name> <month> <date> <numdays> <type1> <number1> <type2> <number2> . . .
		String command_arr[] = command.split(" ", 5); //name= command_arr[0], 
		int date = MonthCalculator.dateToInt(command_arr[1], command_arr[2]);
		int duration = Integer.valueOf(command_arr[3]);
		boolean rooms_available = false;
		
		
		//split booking string into room types and amount
		ArrayList<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile("\\w+ \\d+").matcher(command_arr[4]);
		while (m.find()) {
		   allMatches.add(m.group());
		 }
	
		if(this.hotels.isEmpty()) {
			System.out.println("Booking rejected");
		} else {
			for(Hotel hotel: this.hotels) {
				for(String roomBooking: allMatches) {
					String type_and_amount[] = roomBooking.split(" ", 2);
					if(hotel.checkAvailbility(type_and_amount[0], type_and_amount[1], date,duration)) {
						rooms_available = true;
						//System.out.println("TEST:"+hotel.getName()+ " "+ rooms_available + "typenamount: "  + type_and_amount[0]+" "+ type_and_amount[1]);
					} else {
						rooms_available = false;
						//System.out.println("TEST:"+hotel.getName()+ " "+ rooms_available + "typenamount: "  + type_and_amount[0]+" "+ type_and_amount[1]);
						break;
					}
				}
				if(rooms_available) {
					//Booking Stephanie Burleigh 101
					System.out.print("Booking "+ command_arr[0]+" "+ hotel.getName()+ " ");
					for(String roomBooking: allMatches) {
						String type_and_amount[] = roomBooking.split(" ", 2);
						ArrayList<Integer> rooms = hotel.newBooking(command_arr[0], type_and_amount[0], type_and_amount[1], date,duration);
						for(int room: rooms) {
							System.out.print(room);
							System.out.print(" " );
							
						}
						
					}
					System.out.print("\n");
					return;
				}
			}
			//if got to here was unable to book;
			System.out.println("Booking rejected");
		}
	}
	
	/**
	 * Method when changing a booking, checks if the new boooking is
	 * possible and if so cancels the previous bookins under the name
	 * and books the new request
	 * else rejects change
	 * @param command
	 */
	public void changeCommand(String command) { //todo
		//Change Aarthi Jan 27 3 single 1
		String command_arr[] = command.split(" ", 5); //name= command_arr[0], 
		int date = MonthCalculator.dateToInt(command_arr[1], command_arr[2]);
		int duration = Integer.valueOf(command_arr[3]);
		boolean rooms_available = false;
		
		//split booking string into room types and amount
		ArrayList<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile("\\w+ \\d+").matcher(command_arr[4]);
		while (m.find()) {
		   allMatches.add(m.group());
		 }
		
		//check availbility but treat bookings with occupant as empty
		//if availb, cancel current
		//book the command
		if(this.hotels.isEmpty()) {
			System.out.println("Booking rejected");
		} else {
			for(Hotel hotel: this.hotels) {
				for(String roomBooking: allMatches) {
					String type_and_amount[] = roomBooking.split(" ", 2);
					if(hotel.checkAvailbilityIgnoreSpecific(command_arr[0],type_and_amount[0], type_and_amount[1], date,duration)) {
						rooms_available = true;
					} else {
						rooms_available = false;
						break;
					}
				}
				if(rooms_available) {
					//do cancel command
					this.cancelCommand(command_arr[0]);
					//Booking Stephanie Burleigh 101
					System.out.print("Changing "+ command_arr[0]+" "+ hotel.getName()+ " ");
					for(String roomBooking: allMatches) {
						String type_and_amount[] = roomBooking.split(" ", 2);
						ArrayList<Integer> rooms = hotel.newBooking(command_arr[0], type_and_amount[0], type_and_amount[1], date,duration);
						for(int room: rooms) {
							System.out.print(room);
							System.out.print(" " );
						}
					}
					System.out.print("\n");
					return;
				}
			}
		}
		
		System.out.println("Change rejected");
		// involves checking availbility of booking request
		//if availble then cancel current bookings
		// book the booking, could use the booking command
		//
		

				
	}
	
	/**
	 * Cancels all bookings under specific name
	 * @param command
	 */
	public void cancelCommand(String command) { //done!
		for(Hotel hotel: this.hotels) {
			if(hotel.isPersonStaying(command)) {//check if person is at hotel before tryin to remove from
				hotel.cancelBooking(command);
			}
		}
	}
	
	/**
	 * prints out the hotel specified and the rooms, with the bookings for the year
	 * @param command
	 */
	public void printCommand(String command) { //Done
		//
		for(Hotel hotel: this.hotels) {
			//System.out.println(hotel.getName() + " " + command);
			if(command.matches(hotel.getName())) {
				hotel.printRooms();
				return;
			}
		}
	}

	/**
	 * Main method for the booking system which contains the scanner to read 
	 * the commands from the specified file and passes the commands to 
	 * the command interpretter
	 * @param args
	 */
	public static void main(String[] args) {
		
		HotelBookingSystem bookingSystem = new HotelBookingSystem(); 
		Scanner sc = null;
	    try {
	        sc = new Scanner(new File(args[0]));    // args[0] is the first command line argument
	        // Read input from the scanner here
	        while(sc.hasNextLine()){
	        	bookingSystem.commandInterpreter(sc.nextLine());
	        
	        }
	    }
	    catch (FileNotFoundException e)
	    {
	        System.out.println(e.getMessage());
	    }
	    finally
	    {
	        if (sc != null) sc.close();
	    }
	    
	}
}
