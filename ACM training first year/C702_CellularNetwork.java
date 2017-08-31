//YAY!!
//uploaded

import java.util.Arrays;
import java.util.Scanner;

public class C702_CellularNetwork {

	private static int[] towers;
	private static int[] cities;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		cities = new int[n];
		towers = new int[m];
		int r = 0;
		for (int i = 0; i < n; i++) {
			cities[i] = scan.nextInt();
		}
		for (int i = 0; i < m; i++) {
			towers[i] = scan.nextInt();
		}
		Arrays.sort(towers);
		for (int i = 0; i < n; i++) {
			int dist;
			if (cities[i] < towers[0]) {
				dist = Math.abs(towers[0] - cities[i]);
			} else if (cities[i] > towers[m-1]) {
				dist = Math.abs(cities[i] - towers[m - 1]);
			} else {
				dist = search(0, m-1, i);
			}
			if (dist > r) {
				r = dist;
			}
		}
		System.out.println(r);
		scan.close();
	}

	private static int search (int r, int l, int i) {
		
		if(r == l || Math.abs(l-r) == 1) {
			return min(cities[i]-towers[r], towers[l]- cities[i]);
		}
		int mid = (r+l)/2;
		if (towers[mid] >= cities[i]) {
			return search(r,mid,i);
		} else {
			return search(mid,l,i);
		}
	}
	
	private static int min (int a, int b) {
		return (a < b) ? a : b;
	}
	
}
