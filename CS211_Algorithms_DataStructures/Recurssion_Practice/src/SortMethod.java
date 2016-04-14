
public class SortMethod 
{
	public static void legnthAlphaSort(String[] unsorted)
	{
		for(int outter = 1; outter < unsorted.length; outter++)
		{
			String temp = unsorted[outter]; // back up current var
			int inner = outter; // inner is used to track the shift
			
			while(inner > 0 && unsorted[inner].length() >= temp.length())
			{
				if(unsorted[inner].compareTo(unsorted[inner - 1]) < 0)
					inner--;
				else
					unsorted[inner] = unsorted[inner - 1];
				
			} // while
			
			unsorted[inner] = temp;
		} // for outter
		
		printArray(unsorted);
	} // lengthAlphaSort
	
	public static void printArray(String[] arr)
	{
		for(String x : arr)
			System.out.println(x);
	}
	
	public static void main(String [] args)
	{
		String[] array = new String[10];
		array[0] = "peach";
		array[1] = "apple";
		array[2] = "orange";
		array[3] = "banana";
		array[4] = "pear";
		array[5] = "manderin";
		array[6] = "strawberries";
		array[7] = "blueberries";
		array[8] = "plum";
		array[9] = "kiwi";
		
		printArray(array);
		legnthAlphaSort(array);
		
		
		
		
	}
}
