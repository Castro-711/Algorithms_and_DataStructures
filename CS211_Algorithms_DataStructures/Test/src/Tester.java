import java.util.PriorityQueue;

public class Tester 
{
	public static void main(String [] args)
	{
		PriorityQueue<Object> pq = new PriorityQueue<Object>();
		
		pq.add(10);
		pq.add(22);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	} // main
} // Tester
