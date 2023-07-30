
import java.io.*;
import java.util.*;
import java.lang.*;

public class Static extends Main{
public static void main(String [] args){

    }

    public static String orderID(){

    double alpha1 = 65 + (Math.random() * 26);
    //System.out.println((char)(alpha1));

    int numeric1 = (int)(Math.random() * 10);

    double alpha2 = 65 + (Math.random() * 26);
    //System.out.println((char)alpha2);

    int numeric2 = (int)(Math.random() * 10);

    char strAlpha1 = (char)alpha1;

    String strNumeric1 = numeric1 + "";

    char strAlpha2 = (char)alpha2;

    String strNumeric2 = numeric2 + "";

    String orderID = (strAlpha1 + strNumeric1 + strAlpha2 + strNumeric2);

    return orderID;
    }

    public static void cc_Val(){
		
    	// Creating Scanner Object
    	Scanner input = new Scanner(System.in); 

    	// Input from the user for a credit card number
    	System.out.println("Enter a credit card number as a long integer: ");
    	long number = input.nextLong();

        // Checking for validity
    	if(isValid(number)){
    	System.out.println(number + " is valid!" );
    	}
    	else
    		System.out.println(number + " is invalid!");
    	}

    	//For methods now 

    	/** Return true if the card number is valid */
    	public static boolean isValid(long number) {
    		boolean valid = (getSize(number) >= 13 && getSize(number) <= 16) && (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6)) && ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
    		return valid;
    	}
    	
    	/** Get the result from Step 2 */
    	public static int sumOfDoubleEvenPlace(long number) {
    		int sum = 0;
    		String num = number + "";
    		for (int i = getSize(number) - 2; i >= 0; i -= 2) {
    			sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
    		}
    		return sum;
    	}
    	
    	/** Return this number if it is a single digit, otherwise,
    	* return the sum of the two digits */
    	public static int getDigit(int number) {
    		if (number < 9)
    			return number;
    		else
    			return number / 10 + number % 10;
    	}
    	
    	/** Return sum of odd-place digits in number */
    	public static int sumOfOddPlace(long number) {
    		int sum = 0;
    		String num = number + "";
    		for (int i = getSize(number) - 1; i >= 0; i -= 2) {
    			sum += Integer.parseInt(num.charAt(i) + "");
    		}
    		return sum;
    	}
    	
    	/** Return true if the digit d is a prefix for number */
    	public static boolean prefixMatched(long number, int d) {
    		return getPrefix(number, getSize(d)) == d;
    	}
    	
    	/** Return the number of digits in d */
    	public static int getSize(long d) {
    		String num = d + "";
    		return num.length();
    	}
    	
    	/** Return the first k number of digits from number. If the
    	* number of digits in number is less than k, return number. */
    	public static long getPrefix(long number, int k) {
    		if (getSize(number) > k)  {
    			String num = number + "";
    			return  Long.parseLong(num.substring(0, k));
    	   }

           return number;
    	}
        	
}

	

