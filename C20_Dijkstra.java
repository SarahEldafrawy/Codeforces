//YAY with Youmna !!!
//uploaded

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class C20_Dijkstra {

	private static class vertix{
		 Point point ;
		 int weight;
		public vertix(Point point, int weight) {
			super();
			this.point = point;
			this.weight = weight;
		}
		 
	}
	
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
	
	private static PriorityQueue<vertix> priorityQueue;
	private static LinkedList<Point>[] adjList;
	private static boolean[] V;
	private static int[] dist;
	private static int N;
    private static boolean flag ;

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in) ; 
		N = reader.nextInt();
		int edges = reader.nextInt();
		 priorityQueue = new PriorityQueue<>(N, new Comparator<vertix>()
			 {
				 public int compare(vertix pt1 , vertix pt2){
					 if (pt1.weight > pt2.weight)
						 return 1;
					 else if(pt1.weight == pt2.weight)
						 return 0;
					 return -1;
				 }
		 
		});
		adjList = new LinkedList[N+1];
		V = new boolean[N+1];
		dist = new int [N+1];

		for (int i = 0; i < edges; i++) {
			int tempX = reader.nextInt();
			int tempY = reader.nextInt();
			int tempW = reader.nextInt();
			if (adjList[tempX] == null) {
				
				adjList[tempX] = new LinkedList<>();
			}
			if (adjList[tempY] == null) {
				
				adjList[tempY] = new LinkedList<>();
			}
			adjList[tempX].add(new Point(tempY, tempW));
			adjList[tempY].add(new Point(tempX, tempW));
		}
		priorityQueue.add(new vertix(new Point(-27, 1), 0));
		if(adjList[1] != null)
		Dijkstra();
		if(!flag)
		System.out.println(-1);
		else {
			Stack<Integer> stack = new Stack<>();
			int i = N;
			while(dist[i] != -27) {
				stack.push(i);
				i = dist[i];
			}
			stack.push(i);
			while (!stack.isEmpty()) {
				System.out.println(stack.pop());
			}
		}
	}

	private static void Dijkstra() {
			while (!priorityQueue.isEmpty()) {
				vertix temp;
				do {
				temp = priorityQueue.remove();
				
				} while(V[temp.point.y] && !priorityQueue.isEmpty());
					
				
				dist[temp.point.y] = temp.point.x;
				if (temp.point.y == N) {
					flag = true;
					break;
				}
				V[temp.point.y ] =  true;
				Iterator loop = adjList[temp.point.y].iterator();
				while (loop.hasNext()){
					Point adj = (Point) loop.next();
					if (!V[adj.x]) {
						priorityQueue.add(new vertix(new Point(temp.point.y, adj.x), temp.weight + adj.y));
					}
				}
				
			}
	}
	

}

