package may.week2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14728_벼락치기_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] dp = new int[T+1];
		
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			int time = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			for(int j = T; j >= time; j--) {
				dp[j] = Math.max(dp[j], dp[j-time] + score);
			}
		}
	
		System.out.println(dp[T]);
	}
}
