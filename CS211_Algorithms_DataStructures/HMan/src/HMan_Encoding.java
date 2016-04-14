import java.io.File;
import java.util.ArrayList;

public class HMan_Encoding 
{
	private String unHuffed;
	private File unHuffedFile;
	
	public HMan_Encoding(String pString)
	{
		this.setUnHuffed(pString);
	} // string constructor
	
	public HMan_Encoding(File pFile)
	{
		
	} // file constructor
	
	
	public ArrayList<Character> getUniqueChars()
	{
		ArrayList<Character> flexible = new ArrayList<Character>();
		
		for(int i = 0; i < this.getUnHuffed().length(); i++)
		{
			if(!flexible.contains(this.getUnHuffed().charAt(i)))
				flexible.add(this.getUnHuffed().charAt(i));
		} // for i
		
		return flexible;
	} // getUniqueChars()
	
	
	public int[] getFrequency(int[] freq)
	{
		for(int i = 0; i < this.getUnHuffed().length(); i++)
			freq[(int) this.getUnHuffed().charAt(i)]++;
		
		return freq;
	} // getFrequency
	
	
	public char[] hManSort(ArrayList<Character> uniChars, int[] frequency)
	{
		char[] huffed = new char[uniChars.size()]; // to be returned
		
		for(int y = 0; y < uniChars.size(); y++)
		{
			int yPlusOne = y + 1;
			
			while(yPlusOne < uniChars.size())
			{
				// sort by putting most frequent characters in first
				if(frequency[(int)uniChars.get(y)] < frequency[(int)uniChars.get(yPlusOne)])
				{
					int temp = uniChars.get(y);
					uniChars.set(y, uniChars.get(yPlusOne));
					uniChars.set(yPlusOne, (char)temp);
				} 
				else if(frequency[(int)uniChars.get(y)] == frequency[(int) uniChars.get(yPlusOne)])
				{ // frequencies are equal
					
					if(frequency[(int)uniChars.get(y)] >= frequency[(int)uniChars.get(yPlusOne)])
					{ // sort in alphabetical order
						int temp = uniChars.get(y);
						uniChars.set(y, uniChars.get(yPlusOne));
						uniChars.set(yPlusOne, (char)temp);
					} // if					
				} // else if
				
				yPlusOne++; // increment lcv				
			} // while
		} // for y
		
		for(int i = 0; i < uniChars.size(); i++)
			huffed[i] = uniChars.get(i);
		
		return huffed;
	} // hManSort
	
	
	 // ========================================
	 // GETTERS AND SETTERS
	 // ========================================
	 
	public String getUnHuffed()
	{
		return unHuffed;
	} 
	
	public void setUnHuffed(String pUnHuffed)
	{
		unHuffed = pUnHuffed;
	}
	
	public File getUnHuffedFile()
	{
		return unHuffedFile;
	}
	
	public void setUnHuffedFile(File pUnHuffedFile)
	{
		unHuffedFile = pUnHuffedFile;
	}
}
