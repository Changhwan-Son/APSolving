package jul.week4;

import java.io.*;

public class BOJ_1699_제곱수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			dp[i] = i;
			for(int j = 1 ; j * j <= i ; j++) {
				dp[i] = Math.min(dp[i] , dp[i - j * j] + 1);
			}
		}
		
		System.out.println(dp[N]);
	}
}
