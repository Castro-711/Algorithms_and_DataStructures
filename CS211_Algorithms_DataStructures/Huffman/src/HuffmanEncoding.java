import java.util.ArrayList;

public class HuffmanEncoding 
{
	private ArrayList<Character> uniChars;
	private int[] frequency;
	
	/******* Constructor *******/
	public HuffmanEncoding(String userIn)
	{
		// create array to hold the frequency each char occurs
		frequency = new int[256];
		
		// create a char array list where we can store 
		// the results of the call the getUniqueChars method 
		uniChars = getUniqueChars(userIn, frequency);
		
		// finally call the sort method and
		// wrap it up in a call to print array to see our results
		//printArray(huffmanSort(uniChars, frequency));
	} // string args constructor
	
	public HuffmanEncoding()
	{
		frequency = new int[256];
		
	}
	
	public ArrayList<Character> getUniqueChars(String toConvert, int[] ascii)
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
	
	
	public Node[] huffmanSort(ArrayList<Character> unHuffed, int[] frequency)
	{		
		// this will eventually be returned by this method once the sort is complete
		Node[] huffed = new Node[unHuffed.size()]; 
		
		//this.setFrequency(frequency);
		
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
				if(frequency[(int)unHuffed.get(y)] < frequency[(int)unHuffed.get(sortee)])
				{
					int temp = unHuffed.get(sortee); // store element @ sortee
					unHuffed.set(sortee, unHuffed.get(y)); // put y @ sortee
					unHuffed.set(y, (char) temp); // put sortee @ y
				} // if
				// checks to see if the frequency count is the same
				else if(frequency[(int)unHuffed.get(y)] == frequency[(int)unHuffed.get(sortee)])
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
			huffed[x] = new Node(unHuffed.get(x), frequency[(int)unHuffed.get(x)]);
		
		return huffed;
	} // huffmanSort
	
	public Node[] huffmanSort(Node[] unHuffed, int[] ascii)
	{		
		// this will eventually be returned by this method once the sort is complete
		Node[] huffed = new Node[unHuffed.length]; 
		
		// loop through the array of unique characters present - unHuffed
		for(int y = 0; y < unHuffed.length; y++)
		{
			int sortee = y + 1; // let sortee be one more than y to avoid over calculation
			// then loop while sortee is less than array size
			while(sortee < unHuffed.length )
			{
				// sort by putting the characters that appear most often into 
				// the left of the array list 
				// compares the frequency any given character appears
				if(ascii[(int)unHuffed[y].getUniChar()] < ascii[(int)unHuffed[sortee].getUniChar()])
				{
					Node temp = unHuffed[sortee]; // store element @ sortee
					unHuffed[sortee] = unHuffed[y]; // put y @ sortee
					unHuffed[y] = temp; // put sortee @ y
				} // if
				// checks to see if the frequency count is the same
				else if(ascii[(int)unHuffed[y].getFrequency()] == ascii[(int)unHuffed[sortee].getFrequency()])
				{
					// then we need to compare there ascii values and put
					// in alphabetical order by putting higher values to the right
					if(((int)unHuffed[y].getUniChar()) >= ((int)unHuffed[sortee].getFrequency()))
					{
						Node temp = unHuffed[sortee]; // store element @ sortee
						unHuffed[sortee] = unHuffed[y]; // put y @ sortee
						unHuffed[y] = temp; // put sortee @ y
					} // if 
				} // else if
				
				sortee++; // increment our LCV - Loop Conditional Variable
			} // while
		} // y
		
		// now store our array list in char array to return to caller
		for(int x = 0; x < unHuffed.length; x++)
			huffed[x] = unHuffed[x];
		
		printArray(huffed);
		
		return huffed;
	} // huffmanSort
	
	
	public void printArray(ArrayList<Character> alist)
	{
		for(int i = 0; i < alist.size(); i++)
			System.out.print(alist.get(i) + " ");
	} // alist<char>
	
	public void printArray(char[] alist)
	{
		for(int i = 0; i < alist.length; i++)
			System.out.print(alist[i] + " ");
	} // char[]
	
	public void printArray(Node[] alist)
	{
		for(int i = 0; i < alist.length; i++)
			System.out.print(alist[i] + " ");
	} // char[]

	public ArrayList<Character> getUniChars() 
	{
		return uniChars;
	}

	public void setUniChars(ArrayList<Character> uniChars) 
	{
		this.uniChars = uniChars;
	}

	public int[] getFrequency() 
	{
		return frequency;
	}

	public void setFrequency(int[] frequency) 
	{
		this.frequency = frequency;
	}
	
} // HuffmanEncoding