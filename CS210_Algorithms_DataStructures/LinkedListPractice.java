   public static String check(LinkedList mylist){
        if(mylist.isEmpty())
            return "empty";
        
        Stack<String> myStack = new Stack<String>(); 
        int ticker = 0;
		Link present = mylist.last;
        
        while(present != null)
        {
            stack.push(present.data);
            present = present.previous;
            ticker++; 
            
            if(ticker > 100)
                break;
        } // while
        
        Link latest = mylist.first;
        boolean isSame = true;
        
        while(!stack.empty())
        {
             if(stack.pop() != latest.data)
                isSame = false;
            
            if(latest.next != null)
                latest = latest.next;
        } // while
        
        if(isSame)
            return "TRUE";
        else 
            return "FALSE";
    }
