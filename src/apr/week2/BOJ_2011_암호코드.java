package apr.week2;

import java.io.*;

public class BOJ_2011_암호코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		int len = str.length();
		
		// dp[N] -> N번째 문자까지 나올 수 있는 암호 수 
		long[] dp = new long[len + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		// 암호 잘못되어 해석할 수 없는 경우 
		if(str.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		
		for(int i = 2 ; i <= len; i++) {
			// 암호 문자 하나로 한글자 완성 
			if(str.charAt(i-1) >= '1' && str.charAt(i-1) <= '9') {
				dp[i] += dp[i-1];
			}
			
			// 암호 문자 두개로 한글자 완성 가능 
			if(str.charAt(i-2) == '1' || (str.charAt(i-2) == '2' && str.charAt(i-1) <= '6')) {
				dp[i] += dp[i-2];
			}
			dp[i] %= 1000000;
		}
		
		System.out.println(dp[len]);
	}
}
