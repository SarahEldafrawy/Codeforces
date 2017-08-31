//YAY!!

import java.util.Scanner;

public class A17_NoldBachProblem {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		boolean[] primes = new boolean [n+1];
		
		primes[0] = primes [1] = true; 
		for (int i = 2; i*i < n+1; i++) {
			
			if (primes[i] == false) {
				for (int j = i*i; j < n+1; j+=i) {
					primes[j] = true;
				}
			}
		}
		int count = 0;
		int X1 = 0, X2 = 0, X3 = 0;
		boolean flag = false;
		for (int i = 7; i < n+1; i++) {
			X3 = i;
			if (primes[i] == false) {
			for (int j =  5; j < i; j ++) {
				if (primes[j] == false) {
					X1 = X2;
					X2 = j;
					if (X1 + X2 == X3-1) {
						count++;
						break;
					}
				}
			}
			if (count >=k) {
				flag = true;
				break;
			}
			X2 = 3;
			}
		}
		if (flag || k == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
