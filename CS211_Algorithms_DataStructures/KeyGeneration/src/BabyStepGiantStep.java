import java.util.Scanner;

public class BabyStepGiantStep 
{
	public static void main(String [] args)
	{
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter P:");
		double a = 3;
		double b = 19;
		double k = 5;
		
		for(int i = 1; i < k; i++)
			System.out.println(Math.pow(a, (double) i));
		
		for(int i = 1; i < k; i++)
		{
			double newI = k * i;
			System.out.println(newI);
			System.out.println(Math.pow(a, (double) -i) % b);
		}
			
		
	} // main
	
	
	
} // BabyStepGiantStep
