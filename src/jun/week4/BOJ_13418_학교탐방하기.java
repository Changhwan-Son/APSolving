package jun.week4;

import java.io.*;
import java.util.*;

public class BOJ_13418_학교탐방하기 {

	static class Edge implements Comparable<Edge> {
		int from, to, isDown;

		public Edge(int from, int to, int isDown) {
			this.from = from;
			this.to = to;
			this.isDown = isDown;
		}

		@Override
		public int compareTo(Edge o) {
			return isDown - o.isDown;
		}

	}

	static int N, M;
	static int[] parents;
	static ArrayList<Edge> edgeList;

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
		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken()) + 1;

		parents = new int[N];
		edgeList = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int isDown = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(from, to, isDown));
		}

		make();
		Collections.sort(edgeList);

		int max = 0;
		int count = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				if (edge.isDown == 0)
					max++;
				if (++count == N - 1)
					break;
			}
		}

		make();
		Collections.reverse(edgeList);

		int min = 0;
		count = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				if (edge.isDown == 0)
					min++;
				if (++count == N - 1)
					break;
			}
		}

		System.out.println(max * max - min * min);
	}
}
