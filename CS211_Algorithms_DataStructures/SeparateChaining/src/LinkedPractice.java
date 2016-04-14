import java.util.LinkedList;

public class LinkedPractice 
{
	@SuppressWarnings("unused")
	public static void main(String [] args)
	{
		@SuppressWarnings("rawtypes")
		LinkedList[] hashTable = new LinkedList[100000];
		
		for(int i = 0; i < hashTable.length; i++)
		{
			hashTable[i] = new LinkedList<String>();
		}
	}
}
