package may.week2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14728_벼락치기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][T+1];
		
		for(int i =1 ; i <= N ; i++) {
			st = new StringTokenizer(in.readLine());
			int time = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j <=T; j++) {
				if(j - time >= 0)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time] + score);
				else 
					dp[i][j] = dp[i-1][j];
			}
		}
	
		System.out.println(dp[N][T]);
	}
}
