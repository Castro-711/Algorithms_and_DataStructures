package emc.datastructs.lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File_IO 
{
	static int[] freq;
	
	public ArrayList<Character> loadFile(File loadee) throws IOException
	{
		// declare and init bufferReader
		BufferedReader reader = new BufferedReader(new FileReader(loadee));
		
		freq = new int[256];
		
		// create an arraylist to store the words
		ArrayList<Character> words = new ArrayList<Character>();
		int charCount = 0; // lcv
		String line = null; 
		int lineCount = 0;
		
		while(lineCount < 46)
		{
			if((line = reader.readLine()) == null)
				line = reader.readLine();
			
			for(int i = 0; i < line.length(); i++)
			{
				words.add(line.charAt(i)); // add string to words list
				freq[line.charAt(i)]++;
				charCount++; // increment the word count
			} // for
			
			lineCount++;
		} // while
		
		// you must always close a BufferedReader, "reader" in this case
		// as it leaks resources if not closed properly.
		reader.close();
		
		return words;
	} // loadFile
	
	
	
} // File_IO
