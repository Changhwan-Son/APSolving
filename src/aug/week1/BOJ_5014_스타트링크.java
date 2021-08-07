package aug.week1;

import java.io.*;
import java.util.*;

public class BOJ_5014_스타트링크 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int answer = -1;
		boolean[] visited = new boolean[F+1];

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { S, 0 });
		visited[S] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == G) {
				answer = cur[1];
				break;
			}

			if (cur[0] + U <= F) {
				if (!visited[cur[0] + U]) {
					visited[cur[0] + U] = true;
					queue.add(new int[] { cur[0] + U, cur[1] + 1 });
				}
			}

			if (cur[0] - D > 0) {
				if (!visited[cur[0] - D]) {
					visited[cur[0] - D] = true;
					queue.add(new int[] { cur[0] - D, cur[1] + 1 });
				}
			}
		}

		if (answer != -1)
			System.out.println(answer);
		else
			System.out.println("use the stairs");
	}
}
