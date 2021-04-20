package apr.week3;

import java.io.*;
import java.util.*;

public class fail_BOJ_1446_지름길 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] dp = new int[10001];
		for (int i = 0; i <= D; i++) {
			dp[i] = i;
		}

		int[][] roads = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			roads[i][0] = start;
			roads[i][1] = end;
			roads[i][2] = dis;
		}

		Arrays.sort(roads, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		for (int i = 0; i < N; i++) {
			dp[roads[i][1]] = Math.min(dp[roads[i][1]], dp[roads[i][0]] + roads[i][2]);
		}

		int answer = dp[D];
		for (int i = 0; i <= D; i++) {
			answer = Math.min(answer, dp[i] + D - i);
		}

		System.out.println(answer);
	}
}
