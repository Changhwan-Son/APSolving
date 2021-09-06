package september;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] building = new int[W];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < W; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for(int i = 1 ; i < W - 1; i++) {
			int left = 0;
			int right = 0;
			
			for(int j = 0 ; j < i ; j++)
				left = Math.max(left, building[j]);
			
			for(int j = i + 1; j < W; j++)
				right = Math.max(right, building[j]);
			
			if(building[i] < left && building[i] < right) {
				answer += Math.min(left, right) - building[i];
			}
		}

		System.out.println(answer);
	}
}
