import java.util.ArrayList;
import java.util.Scanner;

public class HuffmanEncoding 
{
	public static void main(String [] args)
	{
		// init scanner and prompt user for input
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: "); // prompt
		String toEncode = input.nextLine(); // store userIn
		
		// create array to hold the frequency each char occurs
		int[] presentAscii = new int[256];
		
		// create a char array list where we can store 
		// the results of the call the getUniqueChars method 
		ArrayList<Character> uniChars = getUniqueChars(toEncode, presentAscii);
		
		// finally call the sort method and
		// wrap it up in a call to print array to see our results
		printArray(huffmanSort(uniChars, presentAscii));
		
	} // main
	
	public static ArrayList<Character> getUniqueChars(String toConvert, int[] ascii)
	{
		ArrayList<Character> uniqueApps = new ArrayList<Character>();
		
		for(int i = 0; i < toConvert.length(); i++)
		{
			 // increment individual char appearances
			ascii[(int)toConvert.charAt(i)]++;
			
			// with a value of one we are certain it is in the string
			// and it ensures we will not get duplicates in our array list
			if(ascii[(int)toConvert.charAt(i)] == 1)
				uniqueApps.add(toConvert.charAt(i));
		} // i 
		
		return uniqueApps;		
	} // getCodes
	
	public static char[] huffmanSort(ArrayList<Character> unHuffed, int[] ascii)
	{		
		// this will eventually be returned by this method once the sort is complete
		char[] huffed = new char[unHuffed.size()]; 
		
		// loop through the array of unique characters present - unHuffed
		for(int y = 0; y < unHuffed.size(); y++)
		{
			int sortee = y + 1; // let sortee be one more than y to avoid over calculation
			// then loop while sortee is less than array size
			while(sortee < unHuffed.size() )
			{
				// sort by putting the characters that appear most often into 
				// the left of the array list 
				// compares the frequency any given character appears
				if(ascii[(int)unHuffed.get(y)] < ascii[(int)unHuffed.get(sortee)])
				{
					int temp = unHuffed.get(sortee); // store element @ sortee
					unHuffed.set(sortee, unHuffed.get(y)); // put y @ sortee
					unHuffed.set(y, (char) temp); // put sortee @ y
				} // if
				// checks to see if the frequency count is the same
				else if(ascii[(int)unHuffed.get(y)] == ascii[(int)unHuffed.get(sortee)])
				{
					// then we need to compare there ascii values and put
					// in alphabetical order by putting higher values to the right
					if(((int)unHuffed.get(y)) >= ((int)unHuffed.get(sortee)))
					{
						int temp = unHuffed.get(sortee); // store element @ sortee
						unHuffed.set(sortee, unHuffed.get(y)); // put y @ sortee
						unHuffed.set(y, (char) temp); // put sortee @ y
					} // if 
				} // else if
				
				sortee++; // increment our LCV - Loop Conditional Variable
			} // while
		} // y
		
		// now store our array list in char array to return to caller
		for(int x = 0; x < unHuffed.size(); x++)
			huffed[x] = unHuffed.get(x);
		
		return huffed;
	} // huffmanSort
	
	public static void printArray(ArrayList<Character> alist)
	{
		for(int i = 0; i < alist.size(); i++)
			System.out.print(alist.get(i) + " ");
	} // alist<char>
	
	public static void printArray(char[] alist)
	{
		for(int i = 0; i < alist.length; i++)
			System.out.print(alist[i] + " ");
	} // char[]
	
} // HuffmanEncoding