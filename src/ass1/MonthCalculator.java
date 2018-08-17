package ass1;

public class MonthCalculator {
	
	//to finish
	public static String intToDate(int date) {
		return Integer.toString(date);
	}
	
	public static int dateToInt(String month, int date) {
		if(month.matches("Jan")) {//31
			
		} else if(month.matches("Feb")) {//28
			date = date + 31; 
		} else if(month.matches("Mar")) {//31
			date = date + 59;
		} else if(month.matches("Apr")) {//30
			date = date + 90;
		} else if(month.matches("May")) {//31
			date = date + 120;
		} else if(month.matches("Jun")) {//30
			date = date + 151;
		} else if(month.matches("Jul")) {//31
			date = date + 181;	
		} else if(month.matches("Aug")) {//31
			date = date + 212;	
		} else if(month.matches("Sep")) {//30
			date = date + 243 ;
		} else if(month.matches("Oct")) {//31
			date = date + 273;
		} else if(month.matches("Nov")) {//30
			date = date + 304;
		} else if(month.matches("Dec")) {//31
			date = date + 334;
		}
		return date;
	}
	
	
}
