import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Problem_22 
{
	public static void main(String [] args)
	{
		try
		{
			BufferedReader in = new BufferedReader(
					new FileReader("//home//castro//workspace//ProjectEuler//res//p022_names.txt"));
		} // try
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found !!!");
		} // catch
		
		List<String> nameList = new ArrayList<String>();
		String currentLine = null;
		
		
	} // main
	

} // Problem_22
