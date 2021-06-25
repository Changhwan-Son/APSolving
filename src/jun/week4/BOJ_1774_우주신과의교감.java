package jun.week4;

import java.io.*;
import java.util.*;

public class BOJ_1774_우주신과의교감 {
	static class Edge implements Comparable<Edge> {

		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight > 0 ? 1 : -1;
		}
	}

	static ArrayList<Edge> edgeList;
	static int[] parents;
	static int N, M;

	static void make() {
		for (int i = 0; i < N; i++)
			parents[i] = i;
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken()); // 우주신들 개수
		M = Integer.parseInt(st.nextToken()); // 이미 연결된 신들과의 통로 개수

		edgeList = new ArrayList<>();
		parents = new int[N + 1];
		int[][] points = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N - 1; i++) {
			for (int j = i + 1; j <= N; j++) {
				edgeList.add(new Edge(i, j, Math
						.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2))));
			}
		}

		Collections.sort(edgeList);

		make();

		double result = 0;
		int count = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			if (union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
				count++;
			}
		}

		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if (++count == N - 1)
					break;
			}
		}

		System.out.printf("%.2f", result);
	}
}
