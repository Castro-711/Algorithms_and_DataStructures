import java.util.Scanner;

public class FirstJavaOnUbuntu
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);		
		int size = 1;
		int[] original = new int[size];
		int average = 0;
		System.out.println(args[0] + " is shit at fifa :P");
		for(int i = 0; i < original.length; i++)
		{
			original[i] = input.nextInt();			
			average += original[i];
		}

		average = average / size;

		System.out.println(average);

		int[] findAverage = new int[size];
				
		for(int i = 0; i < findAverage.length; i++)
			findAverage[i] = Math.abs(original[i] - average);	
		
		int result = findAverage[0];

		for(int i = 0; i < findAverage.length; i++)
		{
			if(findAverage[i] < result && findAverage[i] > 0)
				result = original[i];
		}

		System.out.println("res: " + result);

	} // main
} // class
