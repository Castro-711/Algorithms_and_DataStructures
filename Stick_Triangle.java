import java.util.Scanner;
import java.util.Random;

/*
 * The goal is to get the probability of snapping a stick at two random places
 * that the resulting pieces can be turned into a triangle. I look online to find the 
 * constraints for a triangle in this sense.
 * 
 * If one of the three pieces is greater than half of the stick length then we cannot 
 * have a triangle of the three pieces.
 * 
 * We will use a stick length of 100, and randomly cut it. 
 */

public class Stick_Triangle 
{	
	public static void main(String [] args)
	{
		int stickLen = 100;
		int piece_1 = makeCut(stickLen);
		System.out.println(piece_1);
		int piece_2 = stickLen - piece_1;
		int piece_3 = makeCut(piece_2);
		System.out.println(piece_3);
		piece_2 = piece_2 - piece_3;
		System.out.print(piece_2);
		
	} // main
	
	public static int makeCut(int length)
	{
		Random rand = new Random();
		int cutPoint = rand.nextInt(100) + 1;
		
		return cutPoint;
	} // makeCut
} // Stick_Triangle
