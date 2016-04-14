import java.util.ArrayList;
import java.util.PriorityQueue;

public class Tools 
{
	public void printArray(int[] pArray)
	{
		for(int x: pArray)
			System.out.println(x);
	}
	
	public void printArray(char[] pArray)
	{
		for(int x: pArray)
			System.out.println((char)x);
	}
	
	public void printArray(ArrayList<Character> pArray)
	{
		for(int x: pArray)
			System.out.println((char)x);
	}
	
	public static void main(String [] args)
	{
		Tools t = new Tools();
		
		String temp = "I am the man. The man is me. Therefore me is the man.!";
		
		
		
		HMan_Encoding hMan = new HMan_Encoding(temp);
		hMan.getUniqueChars();
		int[] freq = new int[256];
		char[] array = new char[hMan.getUniqueChars().size()];
		
		freq = hMan.getFrequency(freq);
		
		array = hMan.hManSort(hMan.getUniqueChars(), freq);
		PriorityQueue<Tree> PQ = new PriorityQueue<Tree>();

		for(int i = hMan.getUniqueChars().size() - 1; i >= 0;  i--)
		{
			Tree tree = new Tree();
			Node node = new Node();
			node.uniChar = hMan.getUniqueChars().get(i);
			tree.root = node;
			tree.frequency += freq[(int)node.uniChar];
			
			PQ.add(tree);
		}
		
		for(int i = 0; i < hMan.getUniqueChars().size(); i++)
		{
			System.out.println(PQ.peek().root.uniChar + " -- " + PQ.poll().frequency);
		}
		
		while(PQ.size() > 1)
		{
			
			
			Node n = new Node();
			n.lChild = PQ.poll().root;
			n.rChild = PQ.poll().root;
			n.uniChar = n.lChild.uniChar;
			
			Tree tree = new Tree();
			tree.root = n;
			tree.frequency += freq[n.lChild.uniChar] + freq[n.rChild.uniChar];
			
			tree.compareTo(PQ.poll());
			
			PQ.add(tree);
			System.out.println(PQ.size());
		} // while
		
		Tree hMan_Tree = PQ.poll();
		
		//System.out.println(hMan_Tree.frequency);
		

	}
}
