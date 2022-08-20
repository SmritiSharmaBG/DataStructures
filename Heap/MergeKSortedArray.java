import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Integer> in = new ArrayList<>();
        int ind = 0;
        int i = 0, j = 0;
        while (pq.size() < k) {
            pq.add(new Pair(i, j, arr));
            i++;
        }
        while (ind < k * k) {
            Pair pair = pq.remove();
            int r = pair.i;
            int c = pair.j;
            in.add(arr[r][c]);
            ind ++;
            if (r < k && c + 1 < k)  pq.add(new Pair(r, ++c, arr));
        }

        return in;
    }
    
    private static class Pair implements Comparable<Pair> {
        public int i;
        public int j;
        int number;

        Pair(int i, int j, int[][] arr) {
            this.i = i;
            this.j = j;
            number = arr[i][j];
        }

        @Override
        public int compareTo(Pair p) { // top element should be the smallest number, so Min Heap
            return ((Integer) number).compareTo(p.number);
        }
    }
}
