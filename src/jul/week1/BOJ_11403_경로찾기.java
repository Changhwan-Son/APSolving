package jul.week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] distance = new int[N][N];
		
		StringTokenizer st = null;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ;  j < N ; j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0 ; k < N; k++) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(distance[i][k] == 1 && distance[k][j] == 1)
						distance[i][j] = 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				sb.append(distance[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
