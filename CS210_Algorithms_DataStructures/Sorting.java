import java.util.Scanner;

public class Sorting
{
	public static void main(String [] args)
   	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];

		for(int i = 0; i < array.length; i++)
		{
			array[i] = input.nextInt();
		} // for i

		array = bubbleSort(array);
		printArray(array);
					
   	} // main
	
	public static int[] bubbleSort(int[] unsorted)
	{
		for(int end = unsorted.length -1; end >= 0; end--)
		{
			for(int comp = 1; comp < end - 1; comp++)
			{
				if(unsorted[comp] < unsorted[comp - 1])
					unsorted = swap(unsorted[comp], unsorted[comp + 1], unsorted);			

			} // for comp
		} // for end
	
	return unsorted;
	} // bubbleSort

	public static int[] swap(int first, int second, int[] array)
	{
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
		
		return array;
	} // swap

	public static void printArray(int[] array)
	{
		for(int x = 0; x < array.length; x++)
			System.out.print(array[x] + " ");
	} // printArray
} // Sorting
