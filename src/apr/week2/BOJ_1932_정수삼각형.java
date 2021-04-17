package apr.week2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] map = new int[N][N];
		StringTokenizer st= null;
		
		for(int i = 0 ; i < N ;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < i + 1 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = N - 1 ; i > 0 ; i--) {
			for(int j = 0 ; j < i; j++) {
				map[i-1][j] += Math.max(map[i][j], map[i][j+1]);
			}
		}
		
		System.out.println(map[0][0]);
	}
}
