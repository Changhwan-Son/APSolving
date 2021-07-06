package jul.week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] distance = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1;  j <= N ; j++) {
				distance[i][j] = 5001;
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			distance[s][e] = 1;
			distance[e][s] = 1;
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N; j++) {
				for(int k = 1 ; k <= N ;k++) {
					distance[j][k] = Math.min(distance[j][i] + distance[i][k], distance[j][k]);
				}
			}
		}
		
		int[] answer = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			for(int j = 1 ; j <= N ; j++) {
				if(i == j)
					continue;
				
				sum += distance[i][j];
			}
			answer[i] = sum;
		}
		
		int min = Integer.MAX_VALUE;
		int result = 0;
		for(int i = 1 ; i <= N; i++) {
			if(min > answer[i]) {
				result = i;
				min = answer[i];
			}
		}
		System.out.println(result);
	}
}
