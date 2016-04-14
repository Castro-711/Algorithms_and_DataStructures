
public class Practice 
{
	public static void main(String [] args)
	{
		int counter = 1;
		
		for(int i = 0; i < 100; i++)
		{			
			if(counter == 1 | counter % 3 == 0)
				System.out.println(i + " : " + counter);
			
			counter++;
			
		} // for i
	}
}
