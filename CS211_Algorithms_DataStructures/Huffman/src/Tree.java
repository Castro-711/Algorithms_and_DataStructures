import java.util.ArrayList;
import java.util.PriorityQueue;

public class Tree 
{
	private Node root;
	private static int[] frequency;
	
	public Tree(Node lChild, Node rChild)
	{
		//root = new Node(lChild, rChild);
	}
	
	public static void main(String [] args)
	{
		String temp = "This is an incredible trip.. !";
		HuffmanEncoding huff = new HuffmanEncoding(temp);
		frequency = new int[256];
		
		Node[] leaves = new Node[temp.length()];
		leaves = huff.huffmanSort(huff.getUniqueChars(temp,frequency), frequency);
		
		printNodeArray(leaves);
		
		HuffmanEncoding h = new HuffmanEncoding("This is an incredible trip..!");
//		printArray(h.getFrequency());
		
	}
	
	public Node[] getLeaves(ArrayList<Character> uniChars, int[] frequency)
	{
		Node[] leaves = new Node[uniChars.size()]; // store the leaf nodes
		
		for(int i = 0; i < uniChars.size(); i++)
			leaves[i] = new Node(uniChars.get(i), frequency[(int)uniChars.get(i)]);
		
		return leaves;
	}
	
	public void makeTree(Node[] leaves)
	{
		PriorityQueue<Tree> pq = new PriorityQueue<Tree>();
		
		while(pq.size() > 1)
		{
			
		}
	}
	
	public static void printNodeArray(Node[] nArray)
	{
		for(int i = 0; i < nArray.length; i++)
		{
			System.out.println("--------------");
			System.out.println(nArray[i].getUniChar() + " appears " + nArray[i].getFrequency());
		}
	}
	
	public static void printArray(int[] array)
	{
		for(int i = 0; i < array.length; i++){
			if(array[i] > 0)
				System.out.println(array[i]);
		}
	}
	
	public static void printArray(char[] array)
	{
		for(int i = 0; i < array.length; i++){
			if(array[i] > 0)
				System.out.println(array[i]);
		}
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public void setRoot(Node root)
	{
		this.root = root;
	}
}
