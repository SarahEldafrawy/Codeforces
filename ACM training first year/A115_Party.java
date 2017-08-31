///YAY with Aya!!!!

import java.util.LinkedList;
import java.util.Scanner;

public class A115_Party {
	
	private static int n;
	private static LinkedList [] adjList;
	private static boolean [] roots;
	private static int maxDepth; 
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		n = scan.nextInt();
		adjList = new LinkedList[n];
		roots = new boolean [n];
		
		for (int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < n ; i++) {
			int temp = scan.nextInt();
			if (temp != -1) {
				adjList[temp-1].add(i);
				
			} else {
				roots[i] = true;
			}
		}
		functionTrees ();
		System.out.println(maxDepth);
	}
	
	private static void functionTrees() {
		
		for (int i = 0 ; i < n; i++) {
			if (roots[i]) {
				DFS(i,0);
			}
		}
		
	}
	
	private static void DFS (int i, int count) {
		
		count++;
		if (count > maxDepth) {
			maxDepth = count;
		}
		int len = adjList[i].size();
		for (int j = 0; j < len; j++) {
			DFS ((Integer) adjList[i].get(j), count);
		}
	}
}
