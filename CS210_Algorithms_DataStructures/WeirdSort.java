import java.util.Scanner;

public class WeirdSort
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] ar = new int[n];

		for(int i = 0; i < ar.length; i++)
			ar[i] = input.nextInt();

		bubbleSort(ar);		

	} // main

	public static void bubbleSort(int[] array)
	{
		for(int end = array.length - 1; end >= 0; end--)
		{
			for(int comp = 0; comp < end; comp++)
			{
				if(array[comp] > array[comp + 1])
				{
					int temp = array[comp];
					array[comp] = array[comp + 1];
					array[comp + 1] = temp;
				} // if

			} // for comp
		} // for end
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	} // bubbleSort
	
} // WeirdSort
