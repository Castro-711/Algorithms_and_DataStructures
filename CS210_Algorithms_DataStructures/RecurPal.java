import java.util.Scanner;

public class RecurPal
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		String userString = "";

		while(!userString.equals("no"))
		{
			System.out.println("Enter as string:");
			userString = input.nextLine();
			System.out.println(isPal(userString));					
		} // while
	} // main

	public static String isPal(String possPal)
	{  // you will need between here 
	   //===================================================================
		String substring = ""; // must use this

		// here we are checking if the first char matches the last
		if(possPal.charAt(0) != possPal.charAt(possPal.length() - 1))
			return "FALSE"; // if not return false in a string
		else 
		{ // if they match we come in here
			if(possPal.length() <= 2) // check if it has 2 or less in length
				return "TRUE"; // meaning it is a palindrome :)
			else // if length is not <= 2 then we set substring to everything 
			// but the first and last character, essentially working our 
			// way into the middle
				substring = possPal.substring(1, possPal.length() - 1);
		} // else

		//==================================================================
		// I am confident this will work no problem, giving you 5 passes.

		return isPal(substring); // this line will be in hackerrank
		// that is why above we called it substing as we cant change phils
		// return statement, like the practice the way he gave us value. 
	} // isPal
	
} // RecurPal

