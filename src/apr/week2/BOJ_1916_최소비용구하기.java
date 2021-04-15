package apr.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		int[][] adjMatrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (adjMatrix[s][e] > cost)
				adjMatrix[s][e] = cost;
		}

		int[] distance = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 0;

			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					cur = j;
				}
			}

			visited[cur] = true;
			if (cur == end)
				break;

			for (int j = 1; j <= N; j++) {
				if (!visited[j] && adjMatrix[cur][j] != Integer.MAX_VALUE && distance[j] > min + adjMatrix[cur][j]) {
					distance[j] = min + adjMatrix[cur][j];
				}
			}
		}

		System.out.println(distance[end]);
	}
}
