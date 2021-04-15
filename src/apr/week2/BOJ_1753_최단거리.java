package apr.week2;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());
		
		ArrayList<int[]>[] list = new ArrayList[V+1];
		for(int i = 0 ; i <= V; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 1; i <= E; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new int[] {v, w});
		}
		
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		pq.add(new int[] {K, 0});
		
		while(!pq.isEmpty()) {
			int cur = pq.peek()[0];
			int min = pq.poll()[1];

			for(int[] next : list[cur]) {
				if(distance[next[0]] > min + next[1]) {
					distance[next[0]] = min + next[1];
					pq.add(new int[] {next[0], distance[next[0]]});
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(distance[i]).append("\n");
		}
		System.out.println(sb);
	}
}
