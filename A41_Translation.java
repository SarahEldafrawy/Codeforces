//YAY!!
import java.util.Scanner;

public class A41_Translation {

	private static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		String str1 = scan.next();
		String str2 = scan.next();

		if (str1.length() != str2.length()) {
			System.out.println("NO");
			return;
		}
		int len = str1.length();
		
		for (int i = 0; i < len; i++) {
			if (str1.charAt(i) != str2.charAt(len-i-1)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
}

