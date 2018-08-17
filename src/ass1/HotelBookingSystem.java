package ass1;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import ass1.MonthCalculator;


public class HotelBookingSystem {

	//private String current_command;
	private ArrayList<Hotel> hotels;
	
	public HotelBookingSystem() {
		this.hotels = new ArrayList<Hotel>();
	}
	
	@Override
	public String toString() {
		return "HotelBookingSystem [hotels=" + hotels + "]";
	}

	public void commandInterpreter(String command) {
    	String command_arr[] = command.split(" ",2);
    	
    	//commands:
		if (command_arr[0].matches("Hotel")) {
			System.out.println("Hotel");
			this.hotelCommand(command_arr[1]);
			//Hotel <hotelname> <roomnumber> <capacity>
		} else if (command_arr[0].matches("Print")) {
			System.out.println("Print");
			this.printCommand(command_arr[1]);
			//Print <hotelname>
		} else if (command_arr[0].matches("Booking")) {
			System.out.println("Booking");
			this.bookingCommand(command_arr[1]);
			//Booking <name> <month> <date> <numdays> <type1> <number1> <type2> <number2> . . .
		} else if (command_arr[0].matches("Change")) {
			System.out.println("Change");
			//this.changeCommand(command_arr[1]);
			//Change <name> <month> <date> <numdays> <type1> <number1> <type2> <number2> . . .
		} else if (command_arr[0].matches("Cancel")) {
			System.out.println("Cancel");
			//this.cancelCommand(command_arr[1]);
			//Cancel <name>
		} else {
			System.out.println("CUCKED: "+ command);
		}
		return;
    }
	
	public void hotelCommand(String command) {  //done
		String command_arr[] = command.split(" ",2);
		String roomDetails[] = command_arr[1].split(" ", 2);
		//System.out.println(this.toString());
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
	public void bookingCommand(String command) { //todo
		//Booking <name> <month> <date> <numdays> <type1> <number1> <type2> <number2> . . .
		String command_arr[] = command.split(" ", 5); //name= command_arr[0], 
		int date = MonthCalculator.dateToInt(command_arr[1], command_arr[2]);
		int duration = Integer.valueOf(command_arr[3]);
		
				
		//String bookingList[] = command.split("\w \d+", command_arr[4]);
		
		//split booking string into room types and amount
		ArrayList<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile("\\w+ \\d+").matcher(command_arr[4]);
		while (m.find()) {
		   allMatches.add(m.group());
		 }
		
		for(String roomBooking: allMatches) {
			String type_and_amount[] = roomBooking.split(" ", 2);
			System.out.println("for " + command_arr[0]+ " date: "+date+" duration:"+duration + " type: " + type_and_amount[0] + " amount "+ type_and_amount[1]);
			
			
		}
		
		/*if(this.hotels.isEmpty()) {
			System.out.println("unable to make booking");
		} else {
			for(Hotel hotel: this.hotels) {
				for(String roomBooking: m) {
					String type_and_amount[] = roomBooking.split(" ", 2);
					
				}
			}
		}*/
		
		//checkavailibty on each hotel, find one that has room for all of request
		//loop thru the hotels then loop thru requests on each hotel, if one requests fails return false
		// and try another hotel, if none pass return fail message
		System.out.println(date);
		
		
	}
	public void changeCommand(String command) { //todo
		
	}
	public void cancelCommand(String command) { //todo
		
	}
	public void printCommand(String command) { //Semi done needs formatting properly
		//
		for(Hotel hotel: this.hotels) {
			if(command.matches(hotel.getName())) {
				hotel.printRooms();
				return;
			}
		}
		System.out.println("not a hotel");
	}
		
	public static void main(String[] args) {
		
		HotelBookingSystem bookingSystem = new HotelBookingSystem(); 
		//System.out.println(bookingSystem.toString());
		//System.out.println(bookingSystem.hotels.isEmpty());
		Scanner sc = null;
	    try {
	        sc = new Scanner(new File(args[0]));    // args[0] is the first command line argument
	        // Read input from the scanner here
	        while(sc.hasNextLine()){
	        	//System.out.println(sc.nextLine());
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
