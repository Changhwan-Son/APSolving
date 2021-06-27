package jun.week5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13905_세부 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return o.weight - weight;
		}
	}

	static int V, E, start, end;
	static Edge[] edgeList;
	static int[] parents;

	static void make() {
		for (int i = 1; i <= V; i++)
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
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edgeList = new Edge[E];
		parents = new int[V + 1];

		st = new StringTokenizer(in.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}

		make();
		Arrays.sort(edgeList);

		int result = 0;
		for (int i = 0; i < E; i++) {

			if (union(edgeList[i].from, edgeList[i].to)) {
				if (findSet(start) == findSet(end)) {
					result = edgeList[i].weight;
					break;
				}
			}
		}

		System.out.println(result);
	}
}
