//YAY with Youmna!!!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B230_TPrimes {

	public static class InputReader {
	    private static BufferedReader reader;
	    private static StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }

	    public static String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }

	    public static int nextInt() {
	        return Integer.parseInt(next());
	    }

	    public long nextLong() {
	        return Long.parseLong(next());
	    }          
	}
	
	public static void main(String[] args) {
		
		InputReader scan = new InputReader(System.in);
		boolean[] primes = new boolean [9999999];
		primes[0] = primes [1] = true; 
		for (int i = 2; i < 9999999; i++) {
			
			if (primes[i] == false) {
				for (int j = i*2; j < 9999999; j+=i) {
					primes[j] = true;
				}
			}
		}
		int q = scan.nextInt();
		boolean[] querrries = new boolean [q];
		for (int i = 0; i < q; i++) {
			
			long n =scan.nextLong();
			int  count = 0;
			double n1 = Math.sqrt(n);
			
			if(n1 == (int) n1 && primes[(int) Math.sqrt(n)] == false) {
				count++;
			}
			if (count == 1 && n != 2) {
				querrries[i] = true;
			} 
		}
		
		for (int i = 0; i < q; i++) {
			if (querrries[i]) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}
	
}
