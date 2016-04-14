
public class Tree implements Comparable<Tree>
{
	public Node root;
	public int frequency;
	
	public Tree()
	{
		root = new Node();
	} // 0 args constructor
	
	@Override
	public int compareTo(Tree pTree) 
	{
		if(frequency - pTree.frequency > 0) 
	           return 1;   // compare the cumulative frequencies of the tree
		
	    else if(frequency - pTree.frequency < 0)
	           return -1;  // return 1 or -1 depending on whether these frequencies are bigger or smaller
		
	    else
	           return 0;   // return 0 if they're the same
	} // compareTo

	
	
} // Tree
