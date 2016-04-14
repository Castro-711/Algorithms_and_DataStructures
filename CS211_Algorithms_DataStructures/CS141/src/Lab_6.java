import java.util.Scanner;

public class Lab_6 
{
	static Scanner input = new Scanner(System.in);
	
	public static void question1()
	{
		double[] array = new double[10];
		
		System.out.println("Enter 10 doubles:");
		for(int i = 0; i < array.length; i++)
		{
			System.out.println("Enter double number " + i + " : ");
			array[i] = input.nextDouble();
		} // for
		
		for(int i = 1; i < array.length; i++)
			System.out.println(array[i - 1] + " + " + array[i] 
									+ " = " + (array[i - 1] + array[i]));
		
	} // question1
	
	public static void question2()
	{
		System.out.println("Enter the length of the pendulum, to find the Period:");
		double length = input.nextDouble();
		double g =  9.81;
		
		double period = (2 * Math.PI) * Math.sqrt((length/g));
		
		System.out.println("The period is: " + period);
	} // question2
	
	public static void question3()
	{
		System.out.println("Enter an integer: ");
		int current = input.nextInt();
		
		if(current % 2 == 1)
			System.out.println(current + " is an odd number.. !");
		else
			System.out.println(current + " is an even number.. !");
		
		int count = 0;
		for(int i = 2; i <= current; i++)
		{
			if(current % i == 0)
				count++;
		} // for i
		
		if(count > 1)
			System.out.println(current + " is not prime.. !");
		else 
			System.out.println(current + " is a prime number.. !");
		
	} // question3
	
	public static void question4()
	{
		System.out.println("Enter two integers: ");
		int one = input.nextInt();
		int two = input.nextInt();
		
		int lcv = one * two;
		
		for(int i = lcv; i > 1; i--)
			if(i % one == 0 && i % two == 0)
				lcv = i;
		
		System.out.println("The LCM of " + one + " and " + two + " is: " + lcv);
		
	} // question4
	
	public static void main(String [] args)
	{
		question4();
	} // main
	
} // Lab_6
