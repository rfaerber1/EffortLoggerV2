package application;

/* Code by Raylene Faerber
 * Description: Contains a variety of tests that can be used to check the format of different types of input. 
 * 					Also contains variables with getters that reflect errors found in the input by tests.
 */

public class InputTests {
	
	// the first character in a string that doesn't belong
	char badChar = ' ';
	private void setBadChar(char bad) {
		badChar = bad;
	}
	
	public char getBadChar() {
		return badChar;
	}
	
	// only applies if input has a specific length/format
	boolean correctLength = true;
	private void setCorrectLength(boolean correct) {
		correctLength = correct;
	}
	
	public boolean getCorrectLength() {
		return correctLength;
	}
	
	/**
	 * Checks if String str only contains letters 
	 * (Use getBadChar to see (first) character that doesn't belong)
	 * @param str
	 * @return Returns false if it doesn't, else returns true
	 */
	public Boolean checkForAllLetters(String str) {  
	     for(int i = 0; i < str.length(); i ++) {
	    	 if(!(Character.isLetter(str.charAt(i)) || str.charAt(i) == ' ')){// || (str.charAt(i) == '!' || str.charAt(i) == '?' || str.charAt(i) == '\'')) {
	    		 setBadChar(str.charAt(i));
	    		 return false;
	    	 }
	     }
	     return true;
	}
	
	
	/**
	 * Checks if String str only contains an Integer 
	 * (Use getBadChar to see (first) character that doesn't belong)
	 * @param str
	 * @return Returns false if it doesn't, else returns true
	 */
	public Boolean checkForInt(String str) {
		for(int i = 0; i < str.length(); i ++) {
	    	 if(!(Character.isDigit(str.charAt(i)) || str.charAt(i) == '-')) {
	    		 setBadChar(str.charAt(i));
	    		 return false;
	    	 }
	     }
	     return true;
	}
	
	/**
	 * Checks if String str only contains a Double 
	 * (Use getBadChar to see (first) character that doesn't belong)
	 * @param str
	 * @return Returns false if it doesn't, else returns true
	 * Use getBadChar to see (first) character that doesn't belong
	 */
	public Boolean checkForDouble(String str) {
		for(int i = 0; i < str.length()-1; i ++) {
	    	 if(!(Character.isDigit(str.charAt(i)) || str.charAt(i) == '-' || str.charAt(i) == '.')) {
	    		 setBadChar(str.charAt(i));
	    		 return false;
	    	 }
	     }
	     return true;
	}
	
	/**
	 * Checks if String contains correct format for date yyyy-mm-dd
	 * (Use getBadChar to see (first) character that doesn't belong)
	 * (Use getCorrectLength to see if String is correct length)
	 * @param str
	 * @return Returns false if it doesn't, else returns true
	 */
	public Boolean checkForDate(String str) {  
		setCorrectLength(true);
	    for(int i = 0; i < str.length(); i ++) {
	    	 if(str.charAt(i) != '-' && (i == 4 || i == 7)) {
	    		 setBadChar(str.charAt(i));
	    		 return false;
	    	 }
	    	 else if(!(Character.isDigit(str.charAt(i))) && (i != 4 && i != 7)) {
	    		 setBadChar(str.charAt(i));
	    		 return false;
	    	 }
	     }
	     if (str.length() != 10) {
		 	setCorrectLength(false);
		 	return false;
		 }
		 setCorrectLength(true);
	     return true;
	     
	}
	
	/**
	 * Checks if String contains correct format for time hh:mm:ss
	 * (Use getBadChar to see (first) character that doesn't belong)
	 * (Use getCorrectLength to see if String is correct length)
	 * @param str
	 * @return Returns false if it doesn't, else returns true
	 */
	public Boolean checkForTime(String str) {  
		setCorrectLength(true);
	    for(int i = 0; i < str.length(); i ++) {
	    	if(str.charAt(i) != ':' && (i == 2 || i == 5)) {
	    		 setBadChar(str.charAt(i));
	    		 return false;
	    	 }
	    	 else if(!(Character.isDigit(str.charAt(i))) && (i != 2 && i != 5)) {
	    		 setBadChar(str.charAt(i));
	    		 return false;
	    	 }
	     }
	     if (str.length() != 8) {
		 	setCorrectLength(false);
		 	return false;
		 }
		 setCorrectLength(true);
	     return true;
	}
	
	/**
	 * Checks if String contains any characters it shouldn't for general text
	 * (Use getBadChar to see (first) character that doesn't belong)
	 * @param str
	 * @return Returns false if it doesn't, else returns true
	 */
	public Boolean checkForGeneralText(String str) {  
		for(int i = 0; i < str.length(); i ++) {
	    	 if(!(Character.isAlphabetic(str.charAt(i)) || (Character.isDigit(str.charAt(i))) || str.charAt(i) == ' ' || str.charAt(i) == '.')) {
	    		 setBadChar(str.charAt(i));
	    		 return false;
	    	 }
	     }
	     return true;
	}
	
}
