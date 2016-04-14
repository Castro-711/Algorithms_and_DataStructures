package emc.datastructs.lab5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Flow 
{
	public static String path = "/home/castro/workspace/Crack_Language/res/mystery.txt";
	
	public static void main(String [] args)
	{
		File encrypted = new File(path);
		File_IO io = new File_IO();
		ArrayList<Character> mysteryChars = new ArrayList<Character>();
		
		try { mysteryChars = io.loadFile(encrypted); } 
		catch (IOException e) { e.printStackTrace(); }
		
		Huffman hMan = new Huffman(mysteryChars.toString());
		
		char[] sorted = hMan.hManSort(hMan.getUniqueChars(), File_IO.freq);
		
		ArrayList<Character> withoutChars = newUnis(sorted);
		char[] charWithoutChars = withoutChars.toArray().toString().toCharArray();
		
		System.out.println("The unique character count: " + hMan.getUniqueChars().size() + "\n");
		
		ArrayList<String> bigrams = getUniqueBigrams(mysteryChars);
		int[] biFreqs = getBigramsFrequencies(bigrams, mysteryChars);
		
		getPercentage(mysteryChars.size(), File_IO.freq, sorted);
		System.out.println("**********************************");
		getPercentageCharsList(withoutChars.size() , File_IO.freq, withoutChars);
		
		System.out.println(sorted.length + " --- " + withoutChars.size());
		
		System.out.println("\nUnique Bigrams:\n");
		printStrings(bigrams);
		
//		System.out.println("\nUnique Trigrams:\n");
//		printStrings(getUniqueTrigrams(mysteryChars));
//		
//		System.out.println("\nUnique Quadgrams:\n");
//		printStrings(getUniqueQuadgrams(mysteryChars));
		
		sortBigrams(bigrams, biFreqs);
		
		printStrings(bigrams, biFreqs);
		
		// there are 32 letters in Icelandic alpha 
		// that is why we have 32 * 31 - total possible bigrams
		
		System.out.println("\nBigram percentage:\n");
		getPercentageStringsList(32 * 32, biFreqs, bigrams);
		
		
//		
//		System.out.println(bigrams.size());
//		
		getOriginalChars(sorted, 27);
	} // main
	
	public static ArrayList<Character> newUnis(char[] huffed)
	{
		ArrayList<Character> newUnis = new ArrayList<Character>();	
		
		/*
		 * weird list: 
		 * does not affect the number in the unique array
		 * || huffed[i] == ''
		 * || huffed[i] == '³'  
		 * || huffed[i] == 'ü'
		 * || huffed[i] == 'r' 
		 * || huffed[i] == 'x'  
		 * || huffed[i] == 'U' 
		 * || huffed[i] == 'A' 
		 * || huffed[i] == ''
		 * || huffed[i] == 'Ç'
		 * || huffed[i] == 'Ñ'
		 */
			
		for(int i = 0; i < huffed.length; i++)
		{
			if(!(huffed[i] == 'ù' || huffed[i] == ' ' || huffed[i] == 'þ'
				  || huffed[i] == '©'  || huffed[i] == 'V'  || huffed[i] == '.' 
				  || huffed[i] == 'ã'  || huffed[i] == 'k'  || huffed[i] == 'F' 
				  || huffed[i] == 'ô'  || huffed[i] == '' || huffed[i] == '' 
				  || huffed[i] == '³' || huffed[i] == '[' || huffed[i] == ',' ))
			{ // this covers what I believe are capitals, full stops and spaces
				newUnis.add(huffed[i]);
			}
		}
		
		return newUnis;		
	}
	
	public static void getPercentage(int totalChars, int[] pFreq, char[] unis)
	{
		double total = 0;
		// we want to print each char with a percentage of how often it appears in the text
		for(int i = 0; i < unis.length; i++)
		{
			double currentPercentage = ((double)pFreq[(int) unis[i]]/(double)totalChars) * 100;
			
			System.out.printf("%s appears %.2f\n", unis[i], currentPercentage);
			total += currentPercentage;
		} // for 		
		
		System.out.println("Total is : " + total);
	} // getPercentage
	
	public static void getBigramPercentage(int totalBigrams, int[] pFreq, 
			ArrayList<Character> unis)
	{
		double total = 0;
		// we want to print each char with a percentage of how often it appears in the text
		for(int i = 0; i < unis.size(); i++)
		{
			double currentPercentage = ((double)pFreq[i]/(double)totalBigrams) * 100;
			total += currentPercentage;
			System.out.printf("%s appears %.2f\n", unis.get(i), currentPercentage);
		} // for 		
		
		System.out.println("Total Bigram percentage: " + total);
		
	} // getPercentage
	
	public static void getPercentageCharsList(int totalChars, int[] pFreq, 
			ArrayList<Character> unis)
	{
		
		double total = 0;
		// we want to print each char with a percentage of how often it appears in the text
		for(int i = 0; i < unis.size(); i++)
		{
			double currentPercentage = ((double)pFreq[(int)unis.get(i)]/(double)totalChars) ;
			
			System.out.printf("%s appears %f\n", unis.get(i), currentPercentage);
			total += currentPercentage;
		} // for 	
		
		System.out.println("Total : " + total);
	} // getPercentage
	
	public static void getPercentageStringsList(int totalBigrams, int[] pFreq, 
			ArrayList<String> unis)
	{
		double total = 0;
		// we want to print each char with a percentage of how often it appears in the text
		for(int i = 0; i < unis.size(); i++)
		{
			double currentPercentage = ((double)pFreq[i]/(double)totalBigrams) * 100;
			total += currentPercentage;
			System.out.printf("%s appears %.2f\n", unis.get(i), currentPercentage);
		} // for 		
		
		System.out.println("The total bigram percentage : " + total);
	} // getPercentage
	
	public static void getOriginalChars(char[] unis, int difference)
	{
		char[] converted = new char[unis.length];
		
		for(int i = 0; i < converted.length; i++)
		{
			converted[i] = (char)((int)unis[i] - difference);
		}
		
		//printChars(converted);
	} // getOriginalChars
	
	public static int[] getBigramsFrequencies(ArrayList<String> uniBigrams, 
			ArrayList<Character> fileInChars)
	{
		// store their frequencies in a separate array but in same index
		int[] bigramFreq = new int[uniBigrams.size()];
		
		for(int y = 0; y < bigramFreq.length; y++)
		{
			for(int x = 0; x < fileInChars.size() - 1; x++)
			{
				String temp = fileInChars.get(x) + "" + fileInChars.get(x + 1);
				
				if(uniBigrams.get(y).equals(temp))
					bigramFreq[y]++; // increment the frequency counter
			} // for x
		} // for y
		
		return bigramFreq;
	} // getBigramsFreq
	
	public static ArrayList<String> getUniqueBigrams(ArrayList<Character> fileInChars)
	{
		// this will be returned containing unique bigram's
		ArrayList<String> bigramList = new ArrayList<String>();
		
		int lcv = 0; 
		while(lcv < fileInChars.size() - 1) // - 1 ensures we dodge out of bounds exception
		{
			// use this string to compare with what we already have and decide if it 
			// should be added to the 
			String temp = fileInChars.get(lcv) + "" + fileInChars.get(lcv + 1);
			boolean isNotThere = true; // track if it is in bigramList
			
			int innerLCV = 0;
			while(innerLCV < lcv - 1) 
			{
				String innerTemp = fileInChars.get(innerLCV) + "" + fileInChars.get(innerLCV + 1);
				
				// check to see if we have already added current bigram to our list
				if(temp.equals(innerTemp))
				{
					isNotThere = false;
					break;
				} // if
					
				innerLCV++;
			} // innerLCV
			
			if(isNotThere && temp.length() == 2) // if not already in bigramList - now we can add it
				bigramList.add(temp);
			
			lcv++;
		} // lcv
		
		return bigramList;
	} // getUniqueBigrams
	
	public static void sortBigrams(ArrayList<String> bigrams, int[] pFreqs)
	{
		for(int y = 0; y < bigrams.size(); y++)
		{
			for(int x = 0; x < bigrams.size(); x++)
			{
				if(pFreqs[y] > pFreqs[x])
				{
					int temp = pFreqs[y];
					pFreqs[y] = pFreqs[x];
					pFreqs[x] = temp;
					
					String tempString = bigrams.get(y);
					bigrams.set(y, bigrams.get(x));
					bigrams.set(y, tempString);
				}
			} // x
		} // y
	} // sortBigrams
	
	public static ArrayList<String> getUniqueTrigrams(ArrayList<Character> fileInChars)
	{
		// this will be returned containing unique trigram's
		ArrayList<String> trigramList = new ArrayList<String>();
		
		int lcv = 0; 
		while(lcv < fileInChars.size() - 2) // - 2 ensures we dodge out of bounds exception
		{
			// use this string to compare with what we already have and decide if it 
			// should be added to the 
			String temp = fileInChars.get(lcv) + "" + fileInChars.get(lcv + 1) + "" +
							fileInChars.get(lcv + 2);
			boolean isThere = true; // track if it is in bigramList
			
			int innerLCV = 0;
			while(innerLCV < lcv - 2) 
			{
				String innerTemp = fileInChars.get(innerLCV) + "" + fileInChars.get(innerLCV + 1) 
						+ "" + fileInChars.get(innerLCV + 2);
				
				// check to see if we have already added current bigram to our list
				if(temp.equals(innerTemp))
				{
					isThere = false;
					break;
				} // if
					
				innerLCV++;
			} // innerLCV
			
			if(isThere) // if not already in trigramList - now we can add it
				trigramList.add(temp);
			
			lcv++;
		} // lcv
		
		return trigramList;
	} // getUniqueBTrigrams
	
	public static ArrayList<String> getUniqueQuadgrams(ArrayList<Character> fileInChars)
	{
		// this will be returned containing unique quadgram's
		ArrayList<String> trigramList = new ArrayList<String>();
		
		int lcv = 0; 
		while(lcv < fileInChars.size() - 3) // - 3 ensures we dodge out of bounds exception
		{
			// use this string to compare with what we already have and decide if it 
			// should be added to the 
			String temp = fileInChars.get(lcv) + "" + fileInChars.get(lcv + 1) + "" +
							fileInChars.get(lcv + 2) + "" + fileInChars.get(lcv + 3);
			boolean isThere = true; // track if it is in bigramList
			
			int innerLCV = 0;
			while(innerLCV < lcv - 3) 
			{
				String innerTemp = fileInChars.get(innerLCV) + "" + fileInChars.get(innerLCV + 1) 
						+ "" + fileInChars.get(innerLCV + 2) + "" + fileInChars.get(innerLCV + 3);
				
				// check to see if we have already added current quadgram to our list
				if(temp.equals(innerTemp))
				{
					isThere = false;
					break;
				} // if
					
				innerLCV++;
			} // innerLCV
			
			if(isThere) // if not already in quadgramList - now we can add it
				trigramList.add(temp);
			
			lcv++;
		} // lcv
		
		return trigramList;
	} // getUniqueBigrams
	
	public static void printChars(ArrayList<Character> list, int[] pFreq)
	{
		for(char x : list)
			System.out.println(x + " -- " + pFreq[(int)x]);
	}
	
	public static void printChars(ArrayList<Character> list)
	{
		for(char x : list)
			System.out.println(x);
	}
	
	public static void printStrings(ArrayList<String> list)
	{
		for(String x : list)
			System.out.println(x);
	}
	
	public static void printInts(int[] array)
	{
		for(int x : array)
			System.out.println(x);
	}
	
	public static void printStrings(ArrayList<String> list, int[] pFreq)
	{
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i) + " -- " + pFreq[i]);
	}
	
	public static void printChars(char[] list)
	{
		for(char x : list)
			System.out.println(x + " -- " + File_IO.freq[(int) x]);
	}
}
