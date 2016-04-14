
public class Node 
{
	private char uniChar;
	private int frequency;
	private Node leftChild;
	private Node rightChild;
	
	public Node(char uniChar, int frequency)
	{
		this.setUniChar(uniChar);
		this.setFrequency(frequency);
		leftChild = null;
		rightChild = null;
		
	} // Node
	
	public Node(char uniChar, int frequency, Node lChild, Node rChild)
	{
		this.setUniChar(uniChar);
		this.setFrequency(frequency);
		leftChild = lChild;
		rightChild = rChild;
		
	} // Node
	
	public Node()
	{
		
	}

	public char getUniChar() 
	{
		return uniChar;
	}

	public void setUniChar(char uniChar) 
	{
		this.uniChar = uniChar;
	}
	
	public int getFrequency()
	{
		return frequency;
	}
	
	public void setFrequency(int frequency)
	{
		this.frequency = frequency;
	}
	
	public Node getLeftChild()
	{
		return leftChild;
	}
	
	public void setLeftChild(Node leftChild)
	{
		this.leftChild = leftChild;
	}
	
	public Node getRightChild()
	{
		return rightChild;
	}
	
	public void setRightChild(Node rightChild)
	{
		this.rightChild = rightChild;
	}
	
	
	
	
}
