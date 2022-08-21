import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }       
    }
}

class Solution
{
    private static int size = 0;
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        size ++;
        // first entry
        if (size == 1) {
            maxHeap.add(x);
            minHeap.add(x);
            return;
        }
        
        double m = getMedian();
        // even entry
        if (size % 2 == 0) { 
            if (x < m) { // add in LHS
                maxHeap.remove();
                maxHeap.add(x); 
            } else { // add in RHS
                minHeap.remove();
                minHeap.add(x);
            }
            return;
        }
        
        // odd entry
        if(x < m) { //balance from LHS
            maxHeap.add(x);
            int top = maxHeap.peek();
            minHeap.add(top);
        } else { //balance from RHS
           minHeap.add(x);
           int top = minHeap.peek();
           maxHeap.add(top);
        }
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // No code needed here
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        int lhs = maxHeap.peek();
        int rhs = minHeap.peek();
        double ans= (lhs + rhs) / 2;
        return ans;
    }
}
