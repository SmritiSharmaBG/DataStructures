class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        int[] distance = new int[v];
        for(int i = 0; i < v; i ++) distance[i] = Integer.MAX_VALUE;
        distance[s] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        
        
        pq.add(new Node(s, 0));
        
        while(!pq.isEmpty()) {
            Node i = pq.remove();
            int iDistance = distance[i.node];
            for(ArrayList<Integer> it : adj.get(i.node)) {
                // 0 is node and 1 is distance
                int node = it.get(0);
                int distanceFromI = it.get(1);
                int temp = distanceFromI + iDistance;
                if(temp < distance[node]) {
                    distance[node] = temp;
                    pq.add(new Node(node, temp));
                }
            }
        }
        return distance;
    }
    
    static class Node {
        int node;
        int weight;
        Node(int n, int w) {
            node = n;
            weight = w;
        }
    }
}

