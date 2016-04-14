import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SnakesSolution {

    public static void main(String[] args) 
    { 
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        while(T > 0)
        {
            // declare a 2D string array to act as the board
            String[] board = new String[100];
            for(int i = 0; i < 10; i++)
                Arrays.fill(board, "-");
            
            // declare and init some ladder variables
            int ladderCount = input.nextInt();
            int[] ladderTop = new int[ladderCount];
            int[] ladderFoot = new int[ladderCount];
            int currentLadder = 0;
            
            // read in and store ladder information
            while(currentLadder < ladderCount)
            {
                ladderTop[currentLadder] = input.nextInt();
                ladderFoot[currentLadder] = input.nextInt();
                
                int offSetter = 1; // help align ladders in position on board, 
                if(ladderTop[currentLadder] % 10 == 0 | ladderFoot[currentLadder]% 10 == 0)
                    offSetter = 0; // to avoid getting a out of bounds exception               
                
                board[ladderTop[currentLadder] - offSetter] = "" + currentLadder;
                board[ladderFoot[currentLadder] - offSetter] = "" + currentLadder;
                
                currentLadder++;
                
            } // while ladder
          
            // declare and init some snake variables
            int snakeCount = input.nextInt();
            int[] snakeHead = new int[snakeCount];
            int[] snakeTail = new int[snakeCount];
            int currentSnake = 0;
            
            // read in and store snake information
            while(currentSnake < snakeCount)
            {
                snakeHead[currentSnake] = input.nextInt();
                snakeTail[currentSnake] = input.nextInt();
                
                int snakeOffSet = 1;
                if(snakeHead[currentSnake] % 10 == 0 | snakeTail[currentSnake] % 10 == 0)
                    snakeOffSet = 0;
                
                board[snakeHead[currentSnake] - snakeOffSet] = "x";
                board[snakeTail[currentSnake] - snakeOffSet] = "x";
                
                currentSnake++;
            } // while snake
            
            board[99] = "Y"; // set recognisable string for finalPos
            
//            for(int y = 0; y < 10; y++)
//            {
//                for(int x = 0; x < 10; x++)
//                {
//                    int jumper = 10;
//                    System.out.print(board[x + jumper * y]);
//                } // for x                   
//                
//                System.out.println();
//            } // for y
                
            int position = 1; // current
            int finalPos = 100; // end point 
            int moveCount = 0; // track moves
            
            while(position < 99)
            {
                position = bestMove(position, board);
                moveCount++;
            } // position
            
            System.out.println(moveCount);
            System.out.println("HEY");
            
            T--;
        } // while
    } // main
    
    public static int bestMove(int position, String[] array)
    {
        int bestOption = 6; 
        int nextOptions = 0;
        if(position + 6 < 100)
            nextOptions = position + 6;
        else
            nextOptions = 100 - position;
        
        for(int i = position + 1; i <= position + 6; i++)
        {
            if(array[i].equals("x")) // snake
                i++; 
            else if(array[i].equals("-")) // nothing
                bestOption = i;
            else if(array[i].equals("Y")) // finalPos
                bestOption = 0;
            else // ladder
            {
                int foot = Integer.parseInt(array[i]);
                bestOption = checkForLadderHead(i, array);
            } // else
        } // for
        return bestOption;
    } // bestMove
    
    public static int checkForLadderHead(int foot, String[] array)
    {
        int head = foot;
        for(int i = foot + 1; i < 100; i++)
            if(array[i].equals("" + foot))
                head = i;
            
        return head;
    } // check
} // Solution