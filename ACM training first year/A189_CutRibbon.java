//YaY!!!

import java.util.Scanner;

public class A189_CutRibbon {

	static Scanner scan = new Scanner(System.in);
	private static int [] Dp;
	private static int X1, X2, X3;
	
	public static void main(String[] args) {
		int maxValue;
		int len = scan.nextInt();
		X1 = scan.nextInt();
		X2 = scan.nextInt();
		X3 = scan.nextInt();
		Dp = new int [len + 1];
		
		maxValue = loop(len);
		
		System.out.println(maxValue);
	}
	
	public static int loop (int len){
		
		if (len >= 0 && Dp [len] != 0) {
			return Dp[len];
		} else if (len == 0) {
			return 0;
		} else if (len < X1 && len < X2 && len < X3) {
			if (len >= 0) {
				Dp[len] = Integer.MIN_VALUE;
			}
			return Integer.MIN_VALUE;
		} else {
			Dp [len] = max( 1 + loop (len - X1), 1 + loop(len - X2), 1 + loop(len - X3));
			return Dp[len];
		}
	}
	
	public static int max ( int a,int b, int c) { 
		if (a >= b && a >= c) {
		return a;
		} else if ( b >= a && b >= c) {
			return b;
		} else {
			return c;
		}
	}
	
}
