package jul.week1;

import java.io.*;
import java.util.*;

public class BOJ_18352_특정거리의도시찾기 {

	static class Node implements Comparable<Node> {
		int weight;
		int index;

		public Node(int weight, int index) {
			this.weight = weight;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] distance = new int[N + 1];
		boolean[] check = new boolean[N + 1];
		ArrayList<Node>[] nodeList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			nodeList[A].add(new Node(1, B));
		}

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[X] = 0;
		pq.add(new Node(0, X));

		while (!pq.isEmpty()) {

			Node cur = pq.poll();
			int weight = cur.weight;
			int index = cur.index;

			if (distance[index] < weight)
				continue;

			check[index] = true;

			for (int i = 0; i < nodeList[index].size(); i++) {
				int weight2 = nodeList[index].get(i).weight;
				int index2 = nodeList[index].get(i).index;

				if (distance[index2] > weight2 + weight) {
					distance[index2] = weight2 + weight;
					pq.add(new Node(distance[index2], index2));
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
