package apr.week3;

import java.io.*;
import java.util.*;

public class SWEA_5643_키순서2 {

	static int N, M, adj[][], radj[][];
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adj = new int[N + 1][N + 1];
			radj = new int[N + 1][N + 1];
			
			StringTokenizer st = null;
			int i, j;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = radj[j][i] = 1;
			}

			int answer = 0;
			for (int k = 1; k <= N; k++) {
				cnt = 0;
				dfs(k, adj, new boolean[N + 1]);
				dfs(k, radj, new boolean[N + 1]);
				if (cnt == N - 1)
					answer++;
			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int cur, int[][] adj, boolean[] visited) {
		visited[cur] = true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) {
				dfs(i, adj, visited);
				cnt++;
			}
		}

	}

}

