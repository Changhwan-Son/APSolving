package jun.week5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1915_가장큰정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		String str = "";
		for(int i = 0 ; i < n ; i++) {
			str = in.readLine();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 1 ; i < n ; i++) {
			for(int j = 1 ; j < m ; j++) {
				if(map[i][j] != 0) {
					map[i][j] += Math.min(Math.min(map[i-1][j], map[i][j-1]), map[i-1][j-1]);
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				answer = Math.max(answer, map[i][j]);
			}
		}
		
		System.out.println(answer * answer);
	}
}
