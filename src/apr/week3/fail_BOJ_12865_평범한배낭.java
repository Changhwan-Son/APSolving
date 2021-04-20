package apr.week3;

import java.io.*;
import java.util.StringTokenizer;

public class fail_BOJ_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		int[][] dp = new int[101][100001];
		
		for(int i = 1 ; i <= N ;i++) {
			st = new StringTokenizer(in.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i <= N; i++) {
			for(int j = 0 ; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - weight[i] >= 0)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
			}
		}
		System.out.println(dp[N][K]);
	}
}
