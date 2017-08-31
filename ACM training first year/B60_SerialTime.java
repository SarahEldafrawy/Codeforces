//YAY!!!
import java.util.Scanner;

public final class B60_SerialTime {
	
	private static char[][][] Matrix;
	private static int l,n,m,count = 0;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		l = scan.nextInt();
		n = scan.nextInt();
		m = scan.nextInt();
		String str;
		Matrix = new char [l][n][m];
		
		for (int k = 0; k < l; k++){
			for (int i = 0; i < n; i++){
				str = scan.next();
				Matrix [k][i] = str.toCharArray();
			}
		}
		
		int X = scan.nextInt();
		int Y = scan.nextInt();
		DFS(0,X-1,Y-1);
		System.out.println(count);
	}
	
	private static void DFS (int z, int x, int y) {
		Matrix[z][x][y] = 'T';
		count++;
		if ((z+1)< l 
			&& Matrix[z+1][x][y] != 'T'
			&& Matrix[z+1][x][y] != '#') {
			DFS (z+1,x,y);
		}
		if ((x+1)< n
				&& Matrix[z][x+1][y] != 'T'
				&& Matrix[z][x+1][y] != '#') {
				DFS (z,x+1,y);
		}
		if ((y+1)< m 
				&& Matrix[z][x][y+1] != 'T'
				&& Matrix[z][x][y+1] != '#') {
				DFS (z,x,y+1);
		}
		if ((z-1)>= 0
				&& Matrix[z-1][x][y] != 'T'
				&& Matrix[z-1][x][y] != '#') {
				DFS (z-1,x,y);
		}
		if ((x-1)>= 0
				&& Matrix[z][x-1][y] != 'T'
				&& Matrix[z][x-1][y] != '#') {
				DFS (z,x-1,y);
		}
		if ((y-1) >= 0
				&& Matrix[z][x][y-1] != 'T'
				&& Matrix[z][x][y-1] != '#') {
				DFS (z,x,y-1);
		}
	}

}
