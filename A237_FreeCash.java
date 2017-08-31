//YAY!!
import java.util.Scanner;

public class A237_FreeCash {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] time = new int[24][60];
		int N = scan.nextInt();
		int cash = 0;
		for (int i = 0; i < N; i++) {
			int hr = scan.nextInt();
			int min = scan.nextInt();
			time[hr][min]++;
			if (time[hr][min] > cash) {
				cash = time[hr][min];
			}
		}
		System.out.println(cash);
		
	}
	
}
