package jun.week3;

import java.io.*;
import java.util.*;

public class BOJ_2660_회장뽑기 {
	static int N;
	static boolean[][] friend;
	static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		friend = new boolean[N + 1][N + 1];
		answer = new int[N + 1];
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			if (n1 == -1)
				break;

			friend[n1][n2] = true;
			friend[n2][n1] = true;
		}

		for (int i = 1; i <= N; i++) {
			bfs(i, new boolean[N + 1]);
		}

		StringBuilder sb = new StringBuilder();
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (min == answer[i])
				cnt++;
			if (min > answer[i]) {
				min = answer[i];
				cnt = 1;
			}

		}
		sb.append(min).append(" ").append(cnt).append("\n");

		for (int i = 1; i <= N; i++) {
			if (answer[i] == min)
				sb.append(i).append(" ");
		}
		System.out.println(sb);

	}

	static void bfs(int start, boolean visited[]) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { start, 0 });
		while (!queue.isEmpty()) {
			int cur = queue.peek()[0];
			int c = queue.poll()[1];
			answer[start] = c;

			for (int i = 1; i <= N; i++) {
				if (i == start || i == cur)
					continue;

				if (visited[i] || !friend[cur][i])
					continue;
				visited[i] = true;
				queue.add(new int[] { i, c + 1 });
			}
		}

	}
}
