package jul.week1;

import java.io.*;
import java.util.*;

public class BOJ_1504_특정한최단경로 {

	static class Node implements Comparable<Node> {

		int weight;
		int index;

		Node(int index, int weight) {
			this.weight = weight;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int N, E;
	static ArrayList<Node>[] nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		nodeList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			nodeList[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList[start].add(new Node(end, weight));
			nodeList[end].add(new Node(start, weight));
		}

		st = new StringTokenizer(in.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		int answer1 = 0;
		int a1 = func(1, num1);
		int a2 = func(num1, num2);
		int a3 = func(num2, N);
		answer1 = a1 + a2 + a3;

		int answer2 = 0;
		a1 = func(1, num2);
		a2 = func(num2, num1);
		a3 = func(num1, N);
		answer2 = a1 + a2 + a3;

		if (answer1 > 200000000 && answer2 >= 200000000)
			System.out.println(-1);
		else
			System.out.println(Math.min(answer1, answer2));

	}

	static int func(int start, int end) {
		boolean[] check = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int index = cur.index;
			int weight = cur.weight;

			if (distance[index] < weight)
				continue;

			check[index] = true;

			for (int i = 0; i < nodeList[index].size(); i++) {
				int tweight = nodeList[index].get(i).weight;
				int tindex = nodeList[index].get(i).index;

				if (distance[tindex] > weight + tweight) {
					distance[tindex] = weight + tweight;
					pq.add(new Node(tindex, distance[tindex]));
				}
			}
		}
		return distance[end];
	}
}
