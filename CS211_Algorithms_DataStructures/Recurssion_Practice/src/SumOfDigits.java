import java.util.Arrays;
import java.util.Random;

public class SumOfDigits 
{
	public static void main(String [] args)
	{
		Random rand = new Random();
		int[] ar = new int[10];
		
		for(int i = 0; i < 10; i++)
			ar[i] = rand.nextInt(899) + 100;
		
		singleLineArray(ar, 10);
	} // main
	
	public static int sumOfDigs(int x)
	{
		if(x < 0)
			x *= -1; // make it positive
		
		int y = x % 10; // get the right most digit
		x = x / 10; // remove the right most digit
		
		if(x <= 0) // when y is less than zero - base case
			return y;
		else
			return (y + sumOfDigs(x)); // call method and add result to y
		
	} // sumOfDigs
	
	public static void singleLineArray(int[] x, int xSize)
	{
		int cur = 0;
		
		if(cur == xSize - 1)
			System.out.println(x[cur]);
		else
		{
			System.out.println(x[cur]);
			int[] newAr = Arrays.copyOfRange(x, cur + 1, xSize);
			singleLineArray(newAr, xSize);
		} // else
			
		
	} // singleLineArray
	
} // SumOfDigits
