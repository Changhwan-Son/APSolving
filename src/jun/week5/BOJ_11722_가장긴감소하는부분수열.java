package jun.week5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int[] nums = new int[N];
		int[] dp = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;

			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			if (max != 0)
				dp[i] = max + 1;
		}

		int result = 0;
		for (int i = 0; i < N; i++)
			result = Math.max(result, dp[i]);
		System.out.println(result);
	}
}
