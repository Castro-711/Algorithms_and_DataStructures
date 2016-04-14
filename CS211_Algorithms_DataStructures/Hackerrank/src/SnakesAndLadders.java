import java.util.Scanner;

public class SnakesAndLadders 
{
	public static void main(String [] args)
	{
		int[][] board = new int[10][10];
		String[][] squareProp = new String[10][10];
		int number = 1;
		
		for(int y = 0; y  < board.length; y++)
		{
			for(int x = 0; x < board.length; x++)
			{
				board[y][x] = number++;
			}  // for x
		} // for y
		
		for(int y = 0; y < board.length; y++)
		{
			for(int x = 0; x < board[y].length; x++)
			{
				if(y == 0 && x < 9)
					System.out.print(board[y][x] + "  | ");
				else
					System.out.print(board[y][x] + " | ");
			} // for x 
			System.out.println();
		} // for y
		
		Scanner input = new Scanner(System.in);
		int element = 0;
		
		while(element != -1)
		{
			System.out.println("Enter element to get board number, -1 to quit.");
			element = input.nextInt();
			
			if(element == 100) // hard code 100
				System.out.println("Num @: " + board[9][9]);
			else if(element % 10 > 0) // element / 10 = left value, element % 10 = right value, -1 for array
				System.out.println("Num @: " + board[element / 10 ][(element % 10) - 1]);
			else // the last row are at 0 so we just need element - 1
				System.out.println("Num @: " + board[0][element - 1]);
			
		} // while
	} // main
	
	
} // SnakesAndLadders
