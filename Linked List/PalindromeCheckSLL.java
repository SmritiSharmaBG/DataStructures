class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        // using stack
        //return usingStack(head);
        
        // by reversing
        return func(head);
    }    
    
    
    // BY REVERSING
    
    boolean func(Node head) {
        // find middle
        Node mid = mid(head);
        
        // reverse the second half.
        mid.next = reverse(mid.next);
        
        Node first = head;
        Node sec = mid.next;
        
        while(sec != null) {
            if (first.data != sec.data) return false;
            first = first.next;
            sec = sec.next;
        }
        
        return true;
    }
    
    // reverse the SLL
    Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
    // finds middle. in case of even, returns the first middle
    Node mid(Node head) {
        Node fast, slow;
        fast = slow = head;
        while(slow != null && fast != null && fast.next != null) {
            if (fast.next.next == null) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    
    
    // USING RECURSION
    
    boolean usingStack(Node head) {
        Stack<Integer> stack = new Stack<>();
        
        Node temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        
        temp = head;
        while (temp != null) {
            if (temp.data != stack.pop()) return false;
            temp = temp.next;
        }
        
        return true;
    }
}
