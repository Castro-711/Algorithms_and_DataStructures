

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class Hashing 
{
    static int size = 216555;
    //this is the size of the hash table - a prime number is best
    //static String[] hashTable = new String[size];
    //create the hash table
    static String[] array = new String[216555]; //make sure your String array is big enough to hold all the data
    

	@SuppressWarnings("rawtypes")
	static LinkedList[] hashTable = new LinkedList[size];
	
	static Link[] linkHashTable = new Link[size];
	    
    // a variable to keep the index from the getHashKey so it can be accessed in
    // the getDouble hashing method to save time repeating the same steps
    static int keyIndex;
    
    static BigInteger modSize = new BigInteger("" + size);

    public static void main (String[] args) throws IOException {
      File testFile = new File("/home/castro/workspace/CS211/res/dictionary.txt");     //this is where the file to be sorted is loaded from
//enter the location where you have saved the file of words
      
//      for(int i = 0; i < size; i++)
//      {
//    	  hashTable[i] = new LinkedList<String>();
//      }
      
//      getHashKey("Hello, World!");

//fill the hash table so that every slot contains a space
      getContents(testFile);
//loads up the file
      System.out.println("Which type of open addressing would you like to use?");
      System.out.println("1) Linear Probing");
      System.out.println("2) Quadratic Probing");
      System.out.println("3) Double Hashing");
      Scanner in = new Scanner(System.in);
      int strategy = in.nextInt();
//the user enters a number for the hashing strategy they want to use
      switch(strategy){
          case 1: 
            fillLinearProbing();
            break;
          case 2: 
            fillQuadraticProbing();
            break;
          case 3: 
            fillDoubleHash();
            break;
      }     
      in.nextLine();
      System.out.print("\nEnter a word to find: ");
      String word = in.nextLine();
      while(!word.equals("quit")){
          find(word, strategy);
          System.out.print("\nEnter a word to find: ");
          word = in.nextLine();
//the user is asked to enter words to search for until they enter the word 'quit'
      }
      
      System.out.println("load factor: " + ((double)array.length/(double)size));
    }

     public static void find(String word, int strategy){
//this method takes in a word to look for and the strategy by which it has been placed in the hash table
         int probes = 1;
         int index = getHashKey(word);
//calculate the hash key for the word
         System.out.println();
         while(hashTable[index]!=null&&!hashTable[index].equals(word)){
             System.out.println("Checking slot "+index+"...collision with "+hashTable[index]);
//as long as you do not stumble across either the word or a blank keep searching
            if(strategy==1){
//depending on the strategy go up in linear jumps, quadratic jumps or the double hash jump
                index++;
                probes++;
                index=index%size;
//always mod the index size so it doesn't go out of bounds
            }else if(strategy==2){
                index=index+(probes*probes);
                probes++;
                index=index%size;
            }else if(strategy==3){
                index= getDoubleHashKey(word);
                probes++;
                index=index%size;
            }
        }
         String possWord = linkHashTable[index].getWord();
         
        if(possWord==null){
            System.out.println("NOT IN HASHTABLE");
//if you've found a space then the word cannot be in the hash table
        }
        else{
        	int nextCount = 0;
        	while(possWord != word)
        	{
        		System.out.println(linkHashTable[index].getNext().getWord());
        		possWord = linkHashTable[index].getNext().getWord();
        		nextCount++;
        	}
        	
            System.out.println("The word "+word+" was found in slot "+index+" of the hashtable"
            		+ " and it is " + nextCount + " links down");
        }     
        System.out.println("Number of hash table probes: "+probes);
//print out the total number of attempts to find the correct slot
     }
     

     public static int getHashKey(String word){
//this is the primary hash key function - it should return a number which is a slot in the hash table
//for words, a good strategy is to raise each character to successive powers of the alphabet size
//assume that the alphabet is ASCII characters - a total of 256 possibilities
//each successive character value should be raised to successive powers of 256
//the whole thing is added together and then moduloed to create a hash table index
    	 
    	 BigInteger largeNum = new BigInteger("0");
    	    	 
    	 // get each number by applying above method
    	 for(int i = 0; i < word.length(); i++)
    	 {
    		 // holds the current letter ascii value from the word 
    		 BigInteger curLetterAscii = new BigInteger("" + (int) word.charAt(i));
    		 
    		 // holds the current i value + 1 as not to get zero
    		 // although it works fine with
    		 BigInteger iVal = new BigInteger("" + i);
    		 
    		 BigInteger power = new BigInteger("" + curLetterAscii.multiply(iVal));
    		 largeNum = largeNum.add(curLetterAscii.pow(power.intValue()));
    		 
    		 
    		 power = power.add(BigInteger.ONE);
    		 
    	 } // for
    	 
    	 int tablePosition = largeNum.mod(modSize).intValue();
    	 //System.out.println("tablePosition is: " + tablePosition);
    	 
    	 keyIndex = tablePosition;

        return tablePosition;

      }
     
     

     public static int getDoubleHashKey(String word){
//this method should be different to the primary hash function
//it should return a different number for words which generated the same primary hash key value
//for example, you could just add up all of the letters in the word
    	 
    	 // for the double hash I am going to get the index like above
    	 // for the get hashKey() and take each letter to successive powers
    	 // of the ascii value for the first letter in each word
//    	 System.out.println(hashTable[getHashKey(word)]);
//    	 System.out.println(getHashKey(word));
//    	 System.out.println(word);
    	 
    	// hashTable[keyIndex].addLast(word);
    	 
    	 int start = 0;
    	 BigInteger largeNumber = new BigInteger("" + keyIndex);
    	 int curPower = 256;
    	 
    	 while(start < word.length())
    	 {
    		 BigInteger letterAscii = new BigInteger("" + (int) word.charAt(start));
    		 largeNumber = largeNumber.add(letterAscii.pow(curPower));
    		 
    		 if(curPower < 1)
    			 curPower = 256;
    		 
    		 curPower--;
    		 start++;
    	 }
    	 
    	 int newTablePos = largeNumber.mod(modSize).intValue();

    	 //System.out.println("newTablePos is: " + newTablePos);
    	 
        return newTablePos;
     }
     

     
     public static void fillLinearProbing(){
        int totalcollisions=0;
//this variable stores the total number of collisions that have occurred for every word
        for(int i=0; i<array.length;i++){
//go through all words
           int collisions=0;
           int index = getHashKey(array[i]);
//generate a hash key
           while(hashTable[index]!=null){
//if that slot is already filled move onto the next slot and increment the collisions
               collisions++;
               index++;
               index=index%size;
//make sure you don't go off the edge of the hash table
           }
           hashTable[index].addLast(array[i]);;
           if(i%100==0){
               System.out.println(array[i] + " was placed in slot "+index+" of the hash table after "+collisions+" collisions");
           }
           totalcollisions+=collisions;
//print out the information for the last 1,000 words only, otherwise it takes quite long and gets annoying
       }
        System.out.println("The total number of collisions was "+ totalcollisions);
     }
     
     public static void fillQuadraticProbing(){
         int totalcollisions=0;
         for(int i=0; i<array.length;i++){
           int collisions=0;
           int index = getHashKey(array[i]);
           int queries=1;
           while(hashTable[index]!=null){
               collisions++;
               index=index+(queries*queries);
               index=index%size;
               queries++;
           }
           hashTable[index].addLast(array[i]);
           if(i%100==0){
               System.out.println(array[i] + " was placed in slot "+index+" of the hash table after "+collisions+" collisions");
           } 
           totalcollisions+=collisions;
        }
        System.out.println("The total number of collisions was "+ totalcollisions);
     }
     
     public static void fillDoubleHash(){
        int totalcollisions=0;
        for(int i=0; i<array.length;i++){
           int collisions=0;
           int index = getHashKey(array[i]);
           int doubleHash = getDoubleHashKey(array[i]);
           while(hashTable[index]!=null){
               collisions++;
               index=doubleHash;
               index=index%size;
               linkHashTable[index].setNext(new Link(array[i]));
           }
           System.out.println(array[i]);
           linkHashTable[index] = new Link(array[i]);
           //hashTable[index].add(array[i]);
           if(i%100==0){
               System.out.println(array[i] + " was placed in slot "+index+" of the hash table after "+collisions+" collisions");
           }
           totalcollisions+=collisions;
           
           
        }
        System.out.println("The total number of collisions was "+ totalcollisions);
     }


 /**
 * Fetch the entire contents of a text file, and return it in a String.
 * This style of implementation does not throw Exceptions to the caller.
 *
 * @param aFile is a file which already exists and can be read.
 */
 public static String getContents(File aFile) {
   //...checks on aFile are elided
   StringBuffer contents = new StringBuffer();

   //declared here only to make visible to finally clause
   BufferedReader input = null;
   try {
     //use buffering, reading one line at a time
     //FileReader always assumes default encoding is OK!
     input = new BufferedReader( new FileReader(aFile) );
     String line = null; //not declared within while loop
     /*
     * readLine is a bit quirky :
     * it returns the content of a line MINUS the newline.
     * it returns null only for the END of the stream.
     * it returns an empty String if two newlines appear in a row.
     */
     int i = 0;
     while (( line = input.readLine()) != null){
       array[i]=line;
       i++;
       contents.append(System.getProperty("line.separator"));
     }
   }
   catch (FileNotFoundException ex) {
     ex.printStackTrace();
   }
   catch (IOException ex){
     ex.printStackTrace();
   }
   finally {
     try {
       if (input!= null) {
         //flush and close both "input" and its underlying FileReader
         input.close();
       }
     }
     catch (IOException ex) {
       ex.printStackTrace();
     }
   }
   return contents.toString();
 }


 public static void setContents(File aFile)
                                throws FileNotFoundException, IOException {

   //declared here only to make visible to finally clause; generic reference
   Writer output = null;
   try {
     //use buffering
     //FileWriter always assumes default encoding is OK!
     output = new BufferedWriter( new FileWriter(aFile) );
     int i=0;
     while(array[i]!=null){
       output.write( array[i] );
       output.write(System.getProperty("line.separator"));
       i++;
     }
   }
   finally {
     //flush and close both "output" and its underlying FileWriter
     if (output != null) output.close();
   }
 }
}