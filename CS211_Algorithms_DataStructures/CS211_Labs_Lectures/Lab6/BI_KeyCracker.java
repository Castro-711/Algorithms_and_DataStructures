import java.math.BigInteger;
import java.util.Scanner;

public class BI_KeyCracker 
{
	public static void main(String [] args)
	{
		BigInteger P,		// number to mod g with
				   g, 		// number to be moduloed by P
				   gXModP,	// result of g^x % P
				   x,		// private key
				   c1, 		// (g^x)^y
				   c2,		// m * (g^x)^y
				   m;		// the deciphered message
		
		Scanner input = new Scanner(System.in);
		
		// prompt user for the P value
		System.out.println("Enter a value for P: \n--> ");
		P = new BigInteger(input.nextLong() + "");
		
		// prompt user for the g value
		System.out.println("Enter a value for g: \n--> ");
		g = new BigInteger(input.nextLong() + "");
		
		// prompt user for the gXModP value
		System.out.println("Enter a value for gXModP: \n--> ");
		gXModP = new BigInteger(input.nextLong() + "");
		
		// print out Alice's information
		System.out.println("\nAlice --> \n(" + P + ", " + g + ", " + gXModP + ")\n");
		
		// use gX to make comparisons with gXModP
		BigInteger gX = new BigInteger(g + ""); 
		x = BigInteger.ZERO; // set x = 0 --> key
		
		while(!gX.equals(gXModP))
		{
			x = x.add(BigInteger.ONE); // increment the key 
			gX = g.modPow(x, P); // calculate g^x % P 
		} // while
				
		// print the key
		System.out.println("Key --> " + x );
		
		// prompt user for the c1 value --> 15268076
		System.out.println("\nEnter a value for c1: \n--> ");
		c1 = new BigInteger(input.nextLong() + "");
		
		// prompt user for the c2 value --> 743675
		System.out.println("Enter a value for c2: \n--> ");
		c2 = new BigInteger(input.nextLong() + "");
		
		// print out Bob's information
		System.out.println("\nBob   --> \n(" + c1 + ", " + c2 + ")");
		
		// c1Expon is the value of P - key - 1
		BigInteger c1Expon = new BigInteger(P.subtract(x.add(BigInteger.ONE)) + "");
		
		// calculate the value of m(g^x)^y
		BigInteger mGXY = new BigInteger(c1.modPow(c1Expon, P) + "");
		
		// to find my we multiply mGXY by C2
		m = new BigInteger("" + c2.multiply(mGXY));
		// then % it by P
		m = m.mod(P);
		
		System.out.println("\nDeciphered M --> " + m); 
		
	} // main
} // {}
