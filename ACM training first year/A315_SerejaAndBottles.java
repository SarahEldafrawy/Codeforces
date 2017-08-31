//YAY!!
import java.util.Scanner;

public class A315_SerejaAndBottles {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		boolean [] can = new boolean [N];
		int[][] bottles = new int[N][2];
		int count = 0;
		for(int i = 0; i < N; i++) {
			int x = scan.nextInt() - 1;
			int y = scan.nextInt() - 1;
			bottles[i][0] = x;
			bottles[i][1] = y;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (bottles[j][0] == bottles[i][1] && j!=i) {
					can[j] = true;
				}
			}
		}
		for (int i = 0; i< N; i++) {
			if (!can[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
	
}
