package jul.week2;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {

	static class Edge implements Comparable<Edge> {
		int start, weight;
		
		Edge(int start,int weight) {
			this.start = start;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		boolean[] visited = new boolean[100001];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(N, 0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			visited[e.start] = true;
			
			if(e.start == K) {
				answer = e.weight;
				break;
			}
			if(e.start * 2 <= 100000 && !visited[e.start * 2]) {
				pq.offer(new Edge(e.start * 2, e.weight));
			}
			
			if(e.start + 1 <= 100000 && !visited[e.start + 1]) {
				pq.offer(new Edge(e.start + 1, e.weight + 1));
			}
			
			if(e.start - 1 >= 0 && !visited[e.start  -1]) {
				pq.offer(new Edge(e.start  - 1, e.weight + 1));
			}
		}
		
		System.out.println(answer);
	}
}
