//YAY!!
//uploaded

import java.util.Scanner;

public class C678_JotyAndChocolate {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		int p = scan.nextInt();
		int q = scan.nextInt();
		long res = 0;
		if (a > n && b > n) {
			System.out.println(0);
			return;
		}
		int X = n/a;
		int Y = n/b;
		int Z =  (int) ((long)n / (((long)a * (long)b)/ (long)gcd(a,b)));
		if (p > q) {
			res = (long) X * (long) p;
			res += (long) (Y-Z) * (long) q;
		} else {
			res = (long) Y * (long) q;
			res += (long) (X-Z) * (long) p;
		}
		System.out.println(res);
	}
	
	private static int gcd(int n1, int n2)
	{
	    if (n2 != 0)
	       return gcd(n2, n1%n2);
	    else 
	       return n1;
	}
}
