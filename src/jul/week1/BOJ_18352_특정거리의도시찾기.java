package jul.week1;

import java.io.*;
import java.util.*;

public class BOJ_18352_특정거리의도시찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] distance = new int[N + 1];
		boolean[] check = new boolean[N + 1];
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i = 0 ; i < N + 1; i++)
			adjList.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList.get(A).add(B);
		}

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[X] = 0;

		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;

			for (int j = 1; j <= N; j++) {
				if (!check[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			check[current] = true;

			for (int j = 1; j <= N; j++) {
				if (!check[j] && adjList.get(current).contains(j) && distance[j] > min + 1) {
					distance[j] = min + 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (distance[i] == K)
				sb.append(i).append("\n");
		}

		if (sb.toString().length() == 0)
			sb.append(-1);

		System.out.println(sb);
	}
}
