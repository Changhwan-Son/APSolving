package jul.week2;

import java.io.*;
import java.util.*;

public class BOJ_1939_중량제한 {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return o.weight - this.weight;
		}
	}

	static PriorityQueue<Edge> pq;
	static int N, M;
	static int[] parent, distance;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		distance = new int[N + 1];
		pq = new PriorityQueue<>();
		init();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new Edge(start, end, weight));
		}

		st = new StringTokenizer(in.readLine());
		int fac1 = Integer.parseInt(st.nextToken());
		int fac2 = Integer.parseInt(st.nextToken());

		int answer = Integer.MAX_VALUE;
		int count = 0;
		while (!pq.isEmpty()) {
			if (check(fac1, fac2))
				break;

			Edge cur = pq.poll();
			if (union(cur.start, cur.end)) {
				answer = Math.min(answer, cur.weight);
				if (++count == N - 1)
					break;
			}
		}

		System.out.println(answer);

	}

	static void init() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (a == parent[a])
			return a;

		return parent[a] = find(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parent[bRoot] = aRoot;
		return true;
	}

	static boolean check(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return true;

		return false;
	}
}
