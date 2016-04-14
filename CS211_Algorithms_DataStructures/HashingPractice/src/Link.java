
public class Link 
{
	public String word;
	public int key;
	public Link next;
	
	public Link(String word)
	{
		this.word = word;
	}
	
	public void setNext(Link next)
	{
		this.next = next;
	}
	
	public Link getNext()
	{
		return next;
	}
	
	public void setKey(int key)
	{
		this.key = key;
	}
	
	public int getKey()
	{
		return key;
	}
	
	public void setWord(String word)
	{
		this.word = word;
	}
	
	public String getWord()
	{
		return word;
	}
}
