//YAY!!
//uploaded

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class C427_Checkposts {

	private static LinkedList<Integer>[] adjList;
	private static boolean[] visited;
	private static boolean[] tempV;
	private static Stack<Integer> stack;
	private static int [] low;
	private static int [] disc;
	private static int [] cost;
	private static int N;
	private static long min;
	private static long prob;
	private static long count;
	private static long cosst;
		
	public static class InputReader {
	    private static BufferedReader reader;
	    private static StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }

	    public static String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }

	    public static int nextInt() {
	        return Integer.parseInt(next());
	    }

	    public int nextLong() {
	        return (int) Long.parseLong(next());
	    }          
	}
	
	public static void main(String[] args) {
		
		InputReader scan = new InputReader(System.in);
		
		N = scan.nextInt();
		cost = new int[N+1];
		for (int i = 1; i <= N; i++) {
			cost[i] = scan.nextInt();
		}
		int edges = scan.nextInt();
		adjList = new LinkedList[N + 1];
		for (int i = 0; i < edges; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			if (adjList[x] == null) {
				adjList[x] = new LinkedList<>();
			}
			adjList[x].add(y);
		}
		prob = 1;
		min = Integer.MAX_VALUE;
		low = new int [N+1];
		disc = new int [N+1];
		visited = new boolean [N+1];
		tempV = new boolean [N+1];
		stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				DFS(i);
			}
		}
		System.out.print(cosst + " " + prob);
	}
	
	private static int time = 0;
	
	private static void DFS(int u) {
		
		low[u] = disc[u] = ++time;
		stack.push(u);
		tempV[u] = true;
		visited[u] = true;
		if (adjList[u] != null) {
			Iterator loop = adjList[u].iterator();
			while (loop.hasNext()){
				int temp = (int) loop.next();
				if (disc[temp] == 0 ) {
					DFS(temp);
					low[u]  = min(low[u], low[temp]);
				} else if (visited[temp] && tempV[temp]) {
					low[u] = min(low[u], disc[temp]);
					
				}
			}
		}
		if (low[u] == disc[u]) {
			int z;
			while (stack.peek() != u) {
				z = stack.pop();
				tempV[z] = false;
				if (cost[z] < min) {
					min = cost[z];
					count = 1;
				} else if (cost[z] == min) {
					count++;
					if (count > 1000000007) {
						count %= 1000000007;
					}
				}
			}
			z = stack.pop();
			tempV[z] = false;
			if (cost[z] < min) {
				min = cost[z];
				count = 1;
			} else if (cost[z] == min) {
				count++;
				if (count > 1000000007) {
					count %= 1000000007;
				}
			}
			cosst += min;
			prob *= count;
			if (prob > 1000000007) {
				prob %= 1000000007;
			}
			count = 1;
			min = Integer.MAX_VALUE;
		}
		
	}
	
	public static int min( int a,int b) { 
		return (a <= b ) ? a : b;
	}
}
