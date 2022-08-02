class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> s = new Stack<>();
    	
      // push all elements in the stack
      for (int i = 0; i < n; i++) s.push(i);
      
    	while (s.size() > 1) {
    	    int a = s.pop();
    	    int b = s.pop();
    	    
    	    // A DOESN'T KNOW B BUT B KNOWS A; A CAN BE CELEBRITY
    	    if (M[a][b] == 0 && M[b][a] == 1) s.push(a); 
    	    
    	    // B DOESN'T KNOW A BUT A KNOWS B; B CAN BE CELEBRITY
    	    if (M[b][a] == 0 && M[a][b] == 1) s.push(b); 
    	}
    	
      // cross verification
      int celeb = s.peek();
    	boolean ans = true;
    	for (int i = 0; i < n; i ++) {
    	    // celeb should not know anyone
    	    if (M[celeb][i] == 1) {
    	        ans = false;
    	        break;
    	    }
    	    // everyone should know celeb
    	    if (i != celeb && M[i][celeb] == 0) {
    	        ans = false;
    	        break;
    	    }
    	}
    	if (ans) return celeb; 
    	return -1;
    }
}
