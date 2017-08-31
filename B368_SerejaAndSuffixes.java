//YAY!!!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B368_SerejaAndSuffixes {

	
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

	    public int nextLong() {
	        return (int) Long.parseLong(next());
	    }          
	}
	
	private static int[] arr;
	public static void main(String[] args) {
		InputReader scan = new InputReader(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		arr = new int [n];
		int[] values = new int [n];
		int[] querries = new int[m];
		boolean[] dp = new boolean [100001];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		values[n-1] = 1;
		dp[arr[n-1]] = true;
		for (int i = n-2; i >=0; i--) {
			if (dp[arr[i]]) {
				values[i] = values[i+1];
			} else {
				values[i] = values[i+1] + 1;
				dp[arr[i]] = true;
			}
		}
		
		for(int i = 0; i < m; i++) {
			querries[i] = scan.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			System.out.println(values[querries[i]-1]);
		}
	}
}
