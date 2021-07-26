package jul.week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2225_합분해 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[K+1][N+1];
		
		for(int i = 0 ; i <= K ; i++)
			dp[i][0] = 1;
		
		
		for(int i = 1 ; i <= K ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				dp[i][j] = dp[i][j-1] +dp[i-1][j];
				dp[i][j] %= 1000000000;
			}
		}
		
		System.out.println(dp[K][N]);
	}
}
