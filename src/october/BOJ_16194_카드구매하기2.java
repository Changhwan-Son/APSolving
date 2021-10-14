package october;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16194_카드구매하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] price = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
			dp[i] = price[i];
		}
		
		for(int i = 2 ; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				if(dp[i] > dp[i-j] + price[j])
					dp[i] = dp[i-j] + price[j];
			}
		}
		
		System.out.println(dp[N]);
	}
}
