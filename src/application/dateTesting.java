/*This code was written by
 * Bailey Learned
 */

package testDate;

public class dateTesting {
	
	public static String testDate(String date) {
		int count = 0;
		for(int i = 0; i < date.length(); i ++) { 
	    	if(date.charAt(i) != '-')
	    		 count++;
		}
		if(count != 2)
			return "Date should be in format: yyyy-mm-dd";
		else if(date.charAt(4) != '-' || date.charAt(7) != '-')
			return "Date should be in format: yyyy-mm-dd";
		else if(date.length() != 10)
			return "Date should be in format: yyyy-mm-dd";
		else {
			for(int i = 0; i < 4; i ++) {
				if(!(Character.isDigit(date.charAt(i)))) //characters must be numbers
					return "Invalid input";
			}
			for(int i = 5; i < 7; i ++) {
				if(!(Character.isDigit(date.charAt(i)))) //characters must be numbers
					return "Invalid input";
				if(date.charAt(5) != 0 || date.charAt(5) != 1)
					return "Date is out of range";
				if(date.charAt(5) == 1 && (date.charAt(6) != 0 || date.charAt(6) != 1  || date.charAt(6) != 2))  //only 12 months in a year
					return "Date is out of range";
			}
			for(int i = 8; i < 10; i ++) {
				if(!(Character.isDigit(date.charAt(i)))) //characters must be numbers
					return "Invalid input";
				if(date.charAt(8) != 0 || date.charAt(8) != 1 || date.charAt(8) != 2 || date.charAt(8) != 3)
					return "Date is out of range";
				if(date.charAt(8) == 3 && (date.charAt(9) != 0 || date.charAt(9) != 1)) //day never goes beyond 31
					return "Date is out of range";
				if(date.charAt(5) == 0 && date.charAt(6) == 2 && date.charAt(8) == 3) //February doesn't have 30th or 31st
					return "Date is out of range";
				if(date.charAt(5) == 0 && date.charAt(6) == 4 && date.charAt(9) == 1) //April doesn't have 31st
					return "Date is out of range";
				if(date.charAt(5) == 0 && date.charAt(6) == 6 && date.charAt(9) == 1) //June doesn't have 31st
					return "Date is out of range";
				if(date.charAt(5) == 0 && date.charAt(6) == 9 && date.charAt(9) == 1) //September doesn't have 31st
					return "Date is out of range";
				if(date.charAt(5) == 1 && date.charAt(6) == 1 && date.charAt(9) == 1) //November doesn't have 31st
					return "Date is out of range";
			}
		}
		return "";
	}
}