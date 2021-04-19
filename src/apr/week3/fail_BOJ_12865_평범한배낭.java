package apr.week3;

import java.io.*;
import java.util.StringTokenizer;

public class fail_BOJ_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] bags = new int[N][2];
		int[][] dp = new int[101][100001];
		
		for(int i = 0 ; i < N ;i++) {
			st = new StringTokenizer(in.readLine());
			bags[i][0] = Integer.parseInt(st.nextToken());
			bags[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}
