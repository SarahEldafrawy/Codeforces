
//YAY Youmna!!!

import java.util.Scanner;

public class B456_FedyaAndMaths {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		int n;
		if (str.length() == 1) {
			n = Integer.parseInt(str);
		} else {
			String str2 = str.substring(str.length()-2);
			n = Integer.parseInt(str2);
		}
		n %= 4;
		int res = (int) (1 + Math.pow(2, n) + Math.pow(3, n) + Math.pow(4, n));
		res %= 5;
		System.out.println(res);
	}
}
