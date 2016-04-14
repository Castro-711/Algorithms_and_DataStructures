
public class Queue 
{
	private int maxSize;
	private char queueArray[];
	private int front; 
	private int rear;
	private int nItems;
	
	public Queue(int s)
	{
		maxSize = s;
		queueArray = new char[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	} // Queue
	
	public boolean insert(char c)
	{
		if(isFull()) 
			return false; // deal with if queue is full
		if(rear == maxSize - 1)
			rear = -1;	// deal with wrap around
		rear++; 		// increment
		queueArray[rear] = c; // insert
		nItems++; 		// more items
		return true;
	} // insert
	
	public long remove()
	{
		if(isEmpty())
			return (Long) null; // can't proceed if empty
		long temp = queueArray[front]; // remove from front
		front++; 	// increment front
		if(front == maxSize)
			front = 0;	// deal with wrap around
		nItems--; 		// one less item
		return temp;		
	} // remove
	
	public long peek()
	{
		return queueArray[front];
	} 
	
	public int size()
	{
		return maxSize;
	}
	
	public boolean isFull()
	{
		return (nItems == maxSize);
	}
	
	public boolean isEmpty()
	{
		return (nItems == 0);
	}
	
	public static void main(String [] args)
	{
		Queue que = new Queue(15);
		que.insert('1');
		que.insert('2');
		que.insert('3');
		que.insert('4');
		que.insert('5');
		que.insert('6');
		que.insert('7');
		que.insert('8');
		que.insert('9');
		que.insert('A');
		que.insert('B');
		que.insert('C');
		que.insert('D');
		System.out.println(que.insert('E'));
		System.out.println(que.insert('F'));
		
		System.out.println("Here is the queue: ");
		
		while(!que.isEmpty())
		{
			System.out.println(que.remove());
			System.out.println("Is full: " + que.isFull());
			System.out.println("Is empty: " + que.isEmpty());
		}
		
	}
}
