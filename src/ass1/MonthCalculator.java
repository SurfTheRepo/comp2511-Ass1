package ass1;

public class MonthCalculator {
	
	/**
	 * Takes an int representing the date in the year and 
	 * converts it to month representation eg. 12 becomes "Jan 12"
	 * @param date integer representation of the date
	 * @return date converted to string
	 */
	public static String intToDate(int date) {
		if(date <= 31) {//31
			return "Jan " + date;
		} else if(date <= 59) {//28
			return "Feb " + (date-31); 
		} else if(date <= 90) {//31
			return "Mar " + (date - 59);
		} else if(date <= 120) {//31
			return "Apr " + (date - 90);
		} else if(date <= 151) {//31
			return "May " + (date - 120);
		} else if(date <= 181) {//31
			return "Jun " + (date - 151);
		} else if(date <= 212) {//31
			return "Jul " + (date - 181);	
		} else if(date <= 243) {//31
			return "Aug " + (date - 212);	
		} else if(date <= 273) {//31
			return "Sep " + (date - 243);	
		} else if(date <= 304) {//31
			return "Oct " + (date - 273);	
		} else if(date <= 334) {//31
			return "Nov " + (date - 304);
		} else if(date <= 365) {//31
			return "Dec " + (date - 334);
		}
		return "Hmm";
	}
	
	/**
	 * Converts month and date formant to int format
	 * @param month the month
	 * @param date_as_string the date in the month
	 * @return int as date in the year (out of 365 days)
	 */
	public static int dateToInt(String month, String date_as_string) {
		int date = Integer.valueOf(date_as_string);
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
