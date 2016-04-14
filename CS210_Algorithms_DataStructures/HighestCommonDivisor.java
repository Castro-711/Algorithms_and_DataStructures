import java.util.Scanner;

public class HighestCommonDivisor
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		int more = 0;

		while(more > -1)
		{
			System.out.println("Enter a followed by b");
			long a = input.nextLong();
			long b = input.nextLong();

			System.out.println(gcd(a, b));

			System.out.println("Less than 0 to quit, or greater than for two more numbers");
			more = input.nextInt();		
		} // while
	} // main

	// GetCommonDivisor
	public static long gcd(long x, long y)
	{
		// you need between here, we found this code like this earlier
		// it helped us alot, here is the site: http://www.java-tips.org/java-se-tips-100019/24-java-lang/1890-finding-greatest-common-divisor-recursively.html
	//====================================================
		long one = x;
		long two = y;

		if(two == 0)
			return one;
		else
			one = one % two;
	//===================================================
		// this will not work perfectly, I cant tomorrow because of the
		// way phil has it laid out, so you have to thinker with it 
		// but only slightly.. Can't remember exactly what I done
		// but got it after a few minutes messing ones and twos
		return gcd(two, one); 
		// tomorrow he will have 
		// return gcd (one, two);
		// that is why you will have to mess around.. 
	} // gcd
} // HCD
