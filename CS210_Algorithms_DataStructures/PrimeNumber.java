import java.util.Scanner;

public class PrimeNumber
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int count = 0; // count the number of factors of n

		for(int i = 2; i <= n; i++)
		{
			if(n % i == 0)
			{
				count++; // found a factor
				System.out.println("N = " + n + " i = " + i);
			} // if

		} // for

		if(count < 2)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
	} // main
} // PrimeNumber
