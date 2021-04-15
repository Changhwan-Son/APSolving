package apr.week2;

import java.io.*;

public class SWEA_3819_최대부분배열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N+1];
			for(int i = 1 ; i <= N ; i++) {
				arr[i] = Integer.parseInt(in.readLine());
			}
			
			int sum = 0;
			int max = 0;
			for(int i = 1; i <= N; i++) {
				sum += arr[i];
				max = Math.max(max, sum);
				if(sum < 0)
					sum = 0;
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
