public class SelectionSort
{
	public static void main(String [] args)
	{
		String[] array = {"Ryan", "Eric", "Bailey", "Tuohy", "Raphael",
							"Donnatello", "Leonardo", "Michaelangelo"};

		selectionSort(array);

	} // main
	
	public static void selectionSort(String[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			int x = i;
			while(x < array.length)
			{
				if(array[i].compareTo(array[x]) > 0)
				{
					String temp = array[i];
    	            array[i] = array[x];
	                array[x] = temp;
				} // if

				x++;
			} // while

			printArray(array);
			System.out.println();
		} // for i
	} // selectionSort

	public static void swap(int first, int second)
	{}

	public static void printArray(String [] array)
	{
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + "  ");
	} // printArray

} // SelectionSort
