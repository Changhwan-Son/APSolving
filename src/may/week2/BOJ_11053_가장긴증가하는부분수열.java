package may.week2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] nums = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0 ; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] =1;
		}
		
		for(int i = 1 ; i < N ; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j])
					dp[i] = Math.max(dp[i],dp[j] + 1);
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
