package jul.week3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {

	static int[][] map;
	static int n1 = 0, n2 = 0, n3 = 0;		// -1, 0, 1 개수 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0,0,N);
		
		StringBuilder sb = new StringBuilder();
		sb.append(n1).append("\n");
		sb.append(n2).append("\n");
		sb.append(n3).append("\n");
		System.out.println(sb);
	}
	
	
	static void func(int x, int y, int size) {
		if(check(x,y,size)) {
			if(map[x][y] == -1)
				n1++;
			else if(map[x][y] == 0)
				n2++;
			else
				n3++;
			
			return;
		}
		
		size /= 3;
		
		func(x, y, size);
		func(x + size, y, size);
		func(x + size * 2, y, size);
		func(x, y + size, size);
		func(x + size, y + size, size);
		func(x + size * 2, y + size, size);
		func(x, y + size * 2, size);
		func(x + size, y + size * 2, size);
		func(x + size * 2, y + size * 2, size);
	}
	
	static boolean check(int x, int y, int size) {
		int c = map[x][y];
		for(int i = x; i < x + size ; i++) {
			for(int j = y ; j < y + size ; j++) {
				if(map[i][j] != c)
					return false;
			}
		}
		return true;
	}
}
