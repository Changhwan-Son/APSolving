package jun.week5;

import java.io.*;

public class BOJ_11057_오르막수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] dp = new int[N][10];
		
		for(int i = 0 ; i < 10; i++)
			dp[0][i] = 1;
		
		int result = 0;
		for(int i = 1 ; i < N ; i++) {
			for(int j = 0 ; j < 10; j++) {
				for(int k = 0 ; k <= j ; k++) {
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j] %= 10007;
			}
		}
		
		for(int i = 0 ; i < 10 ; i++)
			result += dp[N-1][i];
		
		System.out.println(result % 10007);
	}
}
