package jun.week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9084_동전 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			int[] price = new int[N];
			for (int i = 0; i < N; i++)
				price[i] = Integer.parseInt(st.nextToken());

			int target = Integer.parseInt(in.readLine());
			int[] dp = new int[target + 1];

			for (int j = 0; j < N; j++) {
				dp[price[j]]++;
				for (int i = price[j] + 1; i <= target; i++) {
					dp[i] += dp[i - price[j]];
				}
			}

			System.out.println(dp[target]);
		}
	}
}
