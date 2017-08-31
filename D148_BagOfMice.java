//YAY!!!
//uploaded

import java.util.Scanner;

public class D148_BagOfMice {

	static Scanner scan = new Scanner(System.in);
	public static double [][] Dp;
	
	public static void main(String[] args) {
		
		int W = scan.nextInt();
		int B = scan.nextInt();
		Dp = new double [W+1][B+1];
		double prob = loop (W, B);
		System.out.printf("%.9f",prob);
	}
	
	public static double loop (int w, int b) {
		
		if (w == 0) {
			return 0;
		} else if (b <= 0) {
			return 1;
		}
		if ( Dp[w][b] != 0) {
			return Dp[w][b];
		} else {
			double all = w + b;
			double y = loop (w, b-3);
			double y2 = ((double)b/all)*((double)(b-1)/(all-1))*y;
			double z = loop (w-1, b-2);
			if (all > 2) {
				y2*=(double)(b-2)/(all-2);
				z*=(double)(w)/(all-2);
			}
			Dp [w][b] = (double)w/all + y2 + ((double)b/all)*((double)(b-1)/(all-1))*z;
			return Dp[w][b];
		}
	}
}
