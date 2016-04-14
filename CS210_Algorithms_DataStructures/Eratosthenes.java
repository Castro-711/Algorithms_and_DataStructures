import java.util.Scanner;
import java.util.Arrays; 

public class Eratosthenes
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		boolean[] array = new boolean[n];

		Arrays.fill(array, Boolean.TRUE);

		for(int i = 0; i < array.length; i++)
		{
			if(i > 1)
			{
				int j = i;
				while(j < array.length)
				{
					if(j % i == 0 & array[j] & i != j)
						array[j] = false;
					j++;
				} // while
			} // if
		} // for

		for(int i = 2; i < array.length; i++)
		{
			if(array[i])
				System.out.println(i);
		} // for
	} // main
} // Eratosthenes




