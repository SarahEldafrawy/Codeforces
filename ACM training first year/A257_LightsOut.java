//YAY!!
import java.util.Scanner;

public class A257_LightsOut {
	
	public static boolean[][] ans;
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ans = new boolean[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ans[i][j] = true;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int k = scan.nextInt();
				if (k%2 == 1) {
					swwitch(i,j);
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ans[i][j])
					System.out.print(1);
				else 
					System.out.print(0);
			}
			System.out.println();
		}		
	}

	private static void swwitch(int k, int l) {
		ans[k][l] = !ans[k][l];
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i+j == 0 || i == j) {
					continue;
				}
				if (k+i >= 0 && l+j >= 0 && k+i < 3 && l+j < 3) {
					ans[k+i][l+j] = !ans[k+i][l+j];
				}
			}
		}
	}
	
}
