package aug.week2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		int start = 0, end = N - 1;
		int sum = Integer.MAX_VALUE;
		int res1 =0, res2 = 0;
		while(start < end) {
			
			int n1 = nums[start];
			int n2 = nums[end];
			
			int mix = Math.abs(n1 + n2);
			if(mix < sum) {
				sum = mix;
				res1 = n1;
				res2 = n2;
			}
			
			if(n1 + n2 < 0)
				start++;
			else
				end--;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(res1).append(" ").append(res2);
		System.out.println(sb);
	}
}
