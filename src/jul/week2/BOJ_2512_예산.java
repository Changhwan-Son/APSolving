package jul.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_2512_예산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long answer = 0;
		int N = Integer.parseInt(in.readLine());
		int[] budgets = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < N; i++)
			budgets[i] = Integer.parseInt(st.nextToken());
		
		long total = Long.parseLong(in.readLine());
		
		Arrays.sort(budgets);
		long left = 0;
		long right = budgets[N-1];
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for(int i = 0 ; i < N ; i++) {
				if(budgets[i] >= mid)
					sum += mid;
				else
					sum += budgets[i];
			}
			
			if(sum > total) {
				right = right - 1;
			}
			else {
				left = mid + 1;
				answer = Math.max(answer, mid);
			}
		}
		
		System.out.println(answer);
	}
}
