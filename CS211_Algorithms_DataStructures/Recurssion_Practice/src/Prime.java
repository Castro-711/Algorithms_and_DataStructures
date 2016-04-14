import java.util.Scanner;

public class Prime 
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What nth Prime would you like to see?");
		int n = input.nextInt();
		int primeCount = 0; // count num of primes
		boolean isPrime; // flag if we have a prime
		
		for(int i = 2; i < n * n; i++)
		{
			int factCount = 0; // count the number of factors for current poss Prime
			isPrime = true;	   // set to true at beginning of each new i
			for(int j = 2; j <= i; j++)
			{
				if(i % j == 0) // check if j is a factor of i
					factCount++; // increment the factor count
				
				if(factCount > 1) // if factor count is greater than one we know its not prime
				{
					isPrime = false; // set flag to false
					break; // break out of loop
				} // if 					
			} // for j
			
			if(isPrime) // check if the prime flag is true
			{ 
				primeCount++;	// increment the prime count
				if(primeCount == n) // check if primeCount == n 
					System.out.println("The " + n + "th Prime number is: " + i); // return the prime at that number
			}
				
		} // for i
	}
	
}
