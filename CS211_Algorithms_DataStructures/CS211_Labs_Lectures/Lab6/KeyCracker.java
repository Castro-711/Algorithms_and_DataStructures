public class KeyCracker 
{
	public static void main(String [] args)
	{
		// (p, g, g^x % p) 	- Alice
		long P = 24852977L;
		long g = 2744L;
		long gModP = 8414508L;
		System.out.println("Alice --> \n(" + P + ", " + g + ", " + gModP + ")\n");
		
		// (g^y, m.g^xy) - Bobs intercepted cipher
		long c1 = 15268076L;
		long c2 = 743675L;	
		System.out.println("Bob   --> \n(" + c1 + ", " + c2 + ")\n");

		 long temp = g; // store the temporary generator
		 long possKey = 1;
		 
		 // search all the poss powers up to gModP for the key
		 while(temp != gModP)
		 {
			 possKey += 1;
			 temp = modMult(temp,g,P);
			 
		 } // while
		 
		 // once out of the loop we are certain we have the key
		 long key = possKey; 

		 System.out.println("Key   --> " + key); 

		 long mGxy = modPower(c1, P-1-key, P);
		 long m = modMult(mGxy, c2, P);

		 System.out.println("\nDeciphered message:\n      --> " + m);

	} // main
	
	/*  		----> modPower <----
	raises a number to a power with the given modulus
	when raising a number to a power, the number quickly becomes too large to 
	handle you need to multiply numbers in such a way that the result is consistently 
	moduloed to keep it in the range however  you  want  the  algorithm  to  work  
	quickly having  a  multiplication loop would result in an O(n) algorithm!
	the trick is to use recursion keep breaking the problem down into smaller 
	pieces and use the modMult method to join them back together */

	public static long modPower(long number, long power, long modulus){
		
		if (power == 0)
			return 1;
		else if (power % 2 == 0) {
			long halfpower = modPower(number, power / 2, modulus);
			return modMult(halfpower, halfpower, modulus);
		} else {
			long halfpower = modPower(number, power / 2, modulus);
			long firstbit = modMult(halfpower, halfpower, modulus);
			return modMult(firstbit, number, modulus);
		} // else
	} //modPower
	
	/*          ----> modMult <-----
	multiplies the first number by the second number with the given modulus
	a  long  can  have  a  maximum  of  19  digits.  Therefore,  if  you're  multiplying 
	two ten digits numbers the usual way, things will go wrong
	you need to multiply numbers in such a way that the result is consistently 
	moduloed to keep it in the range however  you  want  the  algorithm  to  
	work  quickly having  an  addition  loop would result in an O(n) algorithm!
	the trick is to use recursion keep breaking down the multiplication into 
	smaller pieces and mod each of the pieces individually */
	
	public static long modMult(long first, long second, long modulus){
			
		if (second == 0)
			return 0;
		else if (second % 2 == 0) {
			long half = modMult(first, second / 2, modulus);
			return (half + half) % modulus;
		} else {
			long half = modMult(first, second / 2, modulus);
			return (half + half + first) % modulus;
		}
	} // modMult
}
