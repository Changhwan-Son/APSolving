package apr.week2;

import java.io.*;
import java.util.*;

public class SWEA_3927_가장짧은길전부청소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for(int tc = 1; tc <= T ; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] visited = new int[N+1];
			ArrayList<int[]>[] edges = new ArrayList[N+1];
			for(int i = 0 ; i <= N; i++)
				edges[i] = new ArrayList<>();
			
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges[u].add(new int[] {v, w});
				edges[v].add(new int[] {u, w});
			}
			
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {1, 0});
			while(!q.isEmpty()) {
				int cur = q.peek()[0];
				int dis = q.poll()[1];
				for(int[] next : edges[cur]){
	                if(visited[next[0]] == 0) {
	                    visited[next[0]] = visited[cur] + dis;
	                    q.offer(new int[] {next[0], visited[next[0]] });
	                }
	            }
			}
		}
	}
}
