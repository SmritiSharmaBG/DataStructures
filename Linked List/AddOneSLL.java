/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        int carry = rec(head, 0);
        if(carry != 0) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
    
    private static int rec(Node node, int carry) {
        if (node == null) return 1;
        
        carry = rec(node.next, carry);
        
        if(carry != 0) {
            if (node.data < 9) {
                node.data ++;
                carry = 0;
            } else {
                node.data = 0;
                carry = 1;
            }
        }
        return carry;
    }
}
