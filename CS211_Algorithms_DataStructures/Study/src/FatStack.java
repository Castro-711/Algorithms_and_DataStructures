import java.util.Scanner;

public class FatStack 
{
	private int maxSize;
	private char stackArray[];
	private int top;
	
	public FatStack(int s)
	{
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public boolean isEmpty()
	{
		return (top == -1);
	}
	
	public void makeEmpty()
	{
		top = -1;
	}
	
	public boolean isFull()
	{
		return (top == maxSize);
	}
	
	public char peek()
	{
		return stackArray[top];
	}
	
	public void push(char c)
	{
		top++;
		stackArray[top] = c;
	}
	
	public char pop()
	{
		return stackArray[top--];
	}
	
	
	public void printStack()
	{
		int runner = top; // run through the stack
		
		while(runner > -1)
		{
			System.out.println(stackArray[runner]);
			runner--;
		}
	}
	
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String possPal = input.nextLine();
		FatStack stack = new FatStack(possPal.length());
		
		boolean isPal = false;
		
		for(int i = 0; i < possPal.length(); i++)
			stack.push(possPal.charAt(i));
		
		for(int i = 0; i < possPal.length(); i++)
		{
			if(stack.pop() == possPal.charAt(i))
				isPal = true;
			else
			{
				isPal = false;
				break;
			} // else
		} // for
		
		System.out.println("Is " + possPal + " a Palindrome: " + isPal);
	}
}
