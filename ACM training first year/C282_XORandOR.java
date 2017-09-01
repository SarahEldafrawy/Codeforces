//YAY!!!

import java.util.Scanner;

public class C282_XORandOR {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String str1 = scan.next();
		String str2 = scan.next();
		if (str1.length() != str2.length()) {
			System.out.println("NO");
			return;
		}
		int len =str1.length();
		char[] strr1 = str1.toCharArray();
		char[] strr2 = str2.toCharArray();
		
		if (len == 1) {
			if(strr1[0]==strr2[0]) {
				System.out.println("YES");
				return;
			} else {
				System.out.println("NO");
				return;
			}
		}
		
		if (str1.contains("1") && str2.contains("1") || !str1.contains("1") && !str2.contains("1"))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
}
