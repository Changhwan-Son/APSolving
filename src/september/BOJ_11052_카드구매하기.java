package september;

import java.io.*;
import java.util.*;

public class BOJ_11052_카드구매하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] prices = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());

		for (int i = 1; i <= N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + prices[j]);
			}
		}

		System.out.println(dp[N]);
	}
}
