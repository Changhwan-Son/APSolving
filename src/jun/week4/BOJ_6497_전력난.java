package jun.week4;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6497_전력난 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}

	static PriorityQueue<Edge> queue;
	static int[] parents;
	static int m, n;

	static void make() {
		for (int i = 0; i < m; i++)
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
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(in.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			parents = new int[m];
			queue = new PriorityQueue<>();
			if (m == 0 && n == 0)
				break;

			int sum = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				queue.add(new Edge(from, to, weight));
				sum += weight;
			}

			make();

			int result = 0;
			int count = 0;

			while (!queue.isEmpty()) {
				Edge cur = queue.poll();
				if (union(cur.from, cur.to)) {
					result += cur.weight;
					if (++count == m - 1)
						break;
				}
			}

			System.out.println(sum - result);
		}

	}
}
