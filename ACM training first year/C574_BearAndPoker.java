//YAY!!

import java.util.Scanner;

public class C574_BearAndPoker {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int max;
		int N = scan.nextInt();
		int q = scan.nextInt();
		while (q % 2 == 0) {
			q /= 2;
		}
		while (q % 3 == 0) {
			q /= 3;
		}
		max = q;
		for (int i = 1; i < N; i++) {
			q = scan.nextInt();
			while (q%2 == 0) {
				q/=2;
			}
			while (q%3 == 0) {
				q/=3;
			}
			if (q != max) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
}
