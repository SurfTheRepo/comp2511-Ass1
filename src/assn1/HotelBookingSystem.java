package assn1;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class HotelBookingSystem {

	public static void main(String[] args) {
		Scanner sc = null;
	    try {
	        sc = new Scanner(new File(args[0]));    // args[0] is the first command line argument
	        // Read input from the scanner here
	        while(sc.hasNextLine()){
	        	System.out.println(sc.nextLine());
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
	
	
	public void commandInterpreter(String command) {
    	
	//commands:
		//Hotel
			//Hotel <hotelname> <roomnumber> <capacity>
		
		//Booking
			//Booking <name> <month> <date> <numdays> <type1> <number1> <type2> <number2> . . .
		
		//Change
			//Change <name> <month> <date> <numdays> <type1> <number1> <type2> <number2> . . .

		
		//Cancel
			//Cancel <name>
		
		//Print
			//Print <hotelname>
		return;
    }
	
	public void hotelCommand(String command) {
		
	}
	public void bookingCommand(String command) {
		
	}
	public void changeCommand(String command) {
		
	}
	public void cancelCommand(String command) {
		
	}
	public void printCommand(String command) {
		
	}
	
}
