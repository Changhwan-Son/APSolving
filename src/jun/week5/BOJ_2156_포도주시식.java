package jun.week5;

import java.io.*;

public class BOJ_2156_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int[] nums = new int[n + 1];
		int[] dp = new int[n + 1];
		for(int i = 1 ; i <= n ; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		
		dp[1] = nums[1];
		
		if(n > 1)
			dp[2] = nums[1] + nums[2];
		
		for(int i = 3 ; i <= n ; i++) {
			dp[i] = nums[i] + Math.max(nums[i-1] + dp[i-3], dp[i-2]);
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		
		System.out.println(dp[n]);
	}
}
