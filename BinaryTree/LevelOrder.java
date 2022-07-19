class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        level(ans, queue);
        return ans;
    }
    
   static void level(ArrayList<Integer> ans, Queue<Node> queue) {
        if (queue.isEmpty()) return;
        Node temp = queue.remove();
        ans.add(temp.data);
        if (temp.left != null) queue.add(temp.left);
        if (temp.right !=null) queue.add(temp.right);
        level(ans, queue);
    }
}
