package jul.week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] items = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < n ; i++)
			items[i] = Integer.parseInt(st.nextToken());
		
		int[][] distance = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(i == j )
					continue;
				distance[i][j] = 100;
			}			
		}
		
		for(int i = 0 ; i < r ; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			distance[a][b] = c;
			distance[b][a] = c;
		}
		
		for(int k = 0 ; k < n; k++) {
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					distance[i][j] = Math.min(distance[i][k] + distance[j][k], distance[i][j]);
				}
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < n ; i++) {
			int sum = 0;
			for(int j = 0 ; j < n ; j++) {
				if(distance[i][j] <= m)
					sum += items[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
