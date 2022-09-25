class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        //return iterate(head);
        
        return rec(head);
    }
    
    // iterative method
    Node iterate(Node head) {
        Node prev = null;
        Node curr = head;
        if (curr == null) return prev;
        Node nxt = curr.next;
        
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if(curr != null) nxt = curr.next;
        }
        return prev;
    }
    
   // Recursive method
   Node rec(Node head) {
    if(head == null || head.next == null) return head;

    Node rest = rec(head.next);
    head.next.next = head;
    head.next = null;
    return  rest;
   }
}
